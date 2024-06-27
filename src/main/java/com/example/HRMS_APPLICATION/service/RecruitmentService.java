package com.example.HRMS_APPLICATION.service;

import com.example.HRMS_APPLICATION.domain.Application;
import com.example.HRMS_APPLICATION.domain.Job;
import com.example.HRMS_APPLICATION.repository.ApplicationRepository;
import com.example.HRMS_APPLICATION.repository.JobRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentService {
    @Getter
    private final JobRepository jobRepository;
    @Getter
    private final ApplicationRepository applicationRepository;
    @Autowired
    public RecruitmentService(JobRepository jobRepository, ApplicationRepository applicationRepository) {
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
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




    public void createApplication(Application application) {
        this.applicationRepository.createApplication(application);
    }

    public Application getApplication(String applicationId) {
        return this.applicationRepository.getApplication(applicationId);

    }

    public List<Application> getAllApplications() {
        return this.applicationRepository.findAllApplications();
    }

}
