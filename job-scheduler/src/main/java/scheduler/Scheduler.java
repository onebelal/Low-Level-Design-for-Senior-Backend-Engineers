package scheduler;

import entity.Job;

public interface Scheduler {

    void schedule(Job job);

    void cancel(String jobId);

    void pause(String jobId);

    void resume(String jobId);

}