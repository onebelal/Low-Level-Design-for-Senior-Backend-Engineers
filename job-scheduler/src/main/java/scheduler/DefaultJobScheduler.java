package scheduler;

import entity.Job;
import entity.JobStatus;
import repository.JobRepository;
import retry.RetryStrategy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultJobScheduler implements Scheduler {

    private JobRepository repository;

    private ExecutorService workerPool;

    private RetryStrategy retryStrategy;

    private volatile boolean running = true;

    public DefaultJobScheduler(JobRepository repository, RetryStrategy retryStrategy, int workerCount) {
        this.repository = repository;
        this.workerPool = Executors.newFixedThreadPool(workerCount);
        this.retryStrategy = retryStrategy;
    }

    @Override
    public void schedule(Job job) {
        repository.save(job);
    }

    @Override
    public void cancel(String jobId) {
        Job job = repository.find(jobId);
        this.validateJob(job);
        job.setStatus(JobStatus.CANCELLED);
    }

    @Override
    public void pause(String jobId) {
        Job job = repository.find(jobId);
        this.validateJob(job);
        job.setStatus(JobStatus.PAUSED);

    }

    @Override
    public void resume(String jobId) {
        Job job = repository.find(jobId);
        this.validateJob(job);
        job.setStatus(JobStatus.SCHEDULED);
    }

    private static void validateJob(Job job) {
        if (job == null) {
            throw new RuntimeException("Job not found");
        }
    }

    public void start() {

        while (running) {

            for (Job job : repository.findAll()) {
                System.out.println("Job Found "+job.getName());

                if (job.getStatus() != JobStatus.SCHEDULED) {
                    continue;
                }

                if (!job.getTrigger().shouldTrigger()) {
                    continue;
                }
                job.setStatus(JobStatus.RUNNING);
                workerPool.submit(() ->job.getExecutor().command());
            }

            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
    public void stop() {
        running = false;
        workerPool.shutdown();
    }

    private void execute(Job job) {
        try {
            job.setStatus(JobStatus.RUNNING);
            job.getExecutor().command();
            job.setStatus(JobStatus.SUCCESS);
            job.getTrigger().onExecution();
        } catch (Exception e) {
            retryStrategy.retry(job);
        }
    }
}