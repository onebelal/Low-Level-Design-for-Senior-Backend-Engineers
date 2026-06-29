package retry;

import entity.Job;

public interface RetryStrategy {

    void retry(Job attemptCount);

}