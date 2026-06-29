import entity.Job;
import entity.JobStatus;
import executor.EmailJobExecutor;
import repository.JobRepository;
import retry.FixedRetryStrategy;
import retry.RetryStrategy;
import scheduler.DefaultJobScheduler;
import trigger.ImmediateTrigger;

public class JobSchedulerApp {

    public static void main(String[] args) {

        JobRepository repository =
                new JobRepository();

        RetryStrategy retryStrategy =
                new FixedRetryStrategy(3);

        DefaultJobScheduler scheduler =
                new DefaultJobScheduler(
                        repository,
                        retryStrategy,
                        4);

        Job job =
                new Job(
                        "Email Job",
                        JobStatus.SCHEDULED,
                        new ImmediateTrigger(),
                        new EmailJobExecutor());

        System.out.println("Case 1 : Schedule Job");
        scheduler.schedule(job);
        scheduler.start();
        scheduler.stop();

        System.out.println("Case 2 : Schedule Job & Pause Job");
        scheduler.schedule(job);
        scheduler.pause(job.getJobId());

        System.out.println("Case 3 : Resume Job");
        scheduler.resume(job.getJobId());

        System.out.println("Case 4 : Cancel Job");
        scheduler.cancel(job.getJobId());
        //No job will be triggered since its state is cancelled.
        scheduler.start();


    }
}