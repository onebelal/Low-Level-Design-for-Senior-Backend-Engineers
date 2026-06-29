package entity;

import executor.JobCommand;

import java.util.UUID;

public class Job {
    private String jobId;
    private String name;
    private JobStatus status;
    private JobTrigger trigger;
    private JobCommand executor;

    public Job(String name, JobStatus status, JobTrigger trigger, JobCommand executor) {
        this.jobId = UUID.randomUUID().toString();
        this.name = name;
        this.status = status;
        this.trigger = trigger;
        this.executor = executor;
    }

    public String getJobId() {
        return jobId;
    }

    public String getName() {
        return name;
    }

    public JobStatus getStatus() {
        return status;
    }

    public JobTrigger getTrigger() {
        return trigger;
    }

    public JobCommand getExecutor() {
        return executor;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }
}