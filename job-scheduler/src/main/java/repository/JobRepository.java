package repository;

import entity.Job;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JobRepository {

    private final Map<String, Job> jobs = new ConcurrentHashMap<>();

    public void save(Job job) {
        jobs.put(job.getJobId(), job);
    }

    public Job find(String jobId) {
        return jobs.get(jobId);
    }

    public void delete(String jobId) {
        jobs.remove(jobId);
    }

    public List<Job> findAll() {
        return jobs.values().stream().toList();
    }

}