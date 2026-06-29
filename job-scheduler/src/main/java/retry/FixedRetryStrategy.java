package retry;

import entity.Job;
import entity.JobStatus;

public class FixedRetryStrategy
        implements RetryStrategy {

    private final int maxRetry;

    public FixedRetryStrategy(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public void retry(Job job) {
        for (int i = 0; i < maxRetry; i++) {
            try {
                job.getExecutor().command();
                job.setStatus(JobStatus.SUCCESS);
                job.getTrigger().onExecution();
                return;
            } catch (Exception e) {
                System.out.println(
                        "Retry Attempt : " + (i + 1));
            }
        }
        job.setStatus(JobStatus.FAILED);
    }
}