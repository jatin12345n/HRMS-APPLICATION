package com.example.HRMS_APPLICATION.service;

import com.example.HRMS_APPLICATION.model.Application;
import com.example.HRMS_APPLICATION.model.Job;
import com.example.HRMS_APPLICATION.repository.ApplicationRepository;
import com.example.HRMS_APPLICATION.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }}
