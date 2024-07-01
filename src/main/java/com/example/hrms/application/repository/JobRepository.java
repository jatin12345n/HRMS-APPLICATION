package com.example.hrms.application.repository;

import com.example.hrms.application.domain.Job;

import java.util.List;
import java.util.Map;

public interface JobRepository {


    void createJob(Job job);

    Job getApplication(String jobId);

    List<Job> findAllJobs();

    void clearJobs();

    Job updateJob(String jobId, Map<String, Object> updates);

    void deleteJob(String jobId);
}
