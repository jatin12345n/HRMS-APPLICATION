package com.example.hrms.application.repository;

import com.example.hrms.application.exception.JobDoesNotExistException;
import com.example.hrms.application.domain.Job;
import com.example.hrms.application.exception.DuplicateJobIdException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class JobRepositoryInMemory implements JobRepository {

    private final Map<String, Job> jobMap = new ConcurrentHashMap<>();

    @Override
    public void createJob(Job job) throws DuplicateJobIdException {
        Job previousJob = jobMap.putIfAbsent(job.getJobId(), job);
        if (previousJob != null) {
            throw new DuplicateJobIdException(
                    " Job id " + job.getJobId() + " already exists!");

        }
    }

    @Override
    public Job getApplication(String jobId) {
        if (jobMap.containsKey(jobId)) {
            return jobMap.get(jobId);
        } else {
            throw new JobDoesNotExistException("Job is not found");
        }
    }

    @Override
    public List<Job> findAllJobs() {
        return new ArrayList<>(jobMap.values());
    }

    @Override
    public void clearJobs() {
        jobMap.clear();
    }

    @Override
    public Job updateJob(String jobId, Map<String, Object> updates) {
        Job job = jobMap.get(jobId);
        if (job == null) {
            throw new JobDoesNotExistException("Job not found with id " + jobId);
        }
        updates.forEach((key, value) -> {
            switch (key) {
                case "title":
                    job.setTitle((String) value);
                    break;

                case "description":
                    job.setDescription((String) value);
                    break;

            }
        });
        jobMap.put(jobId, job);
        return job;
    }

    @Override
    public void deleteJob(String jobId) {
        jobMap.remove(jobId);

    }
}
