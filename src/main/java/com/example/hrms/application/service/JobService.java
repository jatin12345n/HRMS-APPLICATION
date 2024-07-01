package com.example.hrms.application.service;

import com.example.hrms.application.repository.JobRepository;
import com.example.hrms.application.domain.Job;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JobService {
    @Getter
    private final JobRepository jobRepository;


    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;

    }

    public void createJob(Job job) {
        this.jobRepository.createJob(job);
    }


    public Job getJob(String jobId) {
        return this.jobRepository.getApplication(jobId);
    }


    public List<Job> getAllJobs() {
        return this.jobRepository.findAllJobs();
    }


    public Job updateJob(String jobId, Map<String, Object> updates) {
       return this.jobRepository.updateJob(jobId,updates);
    }

    public void deleteJob(String jobId) {
        this.jobRepository.deleteJob(jobId);
    }
}
