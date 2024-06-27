package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface JobRepository{


    void createJob(Job job);

    Job getApplication(String jobId);

    List<Job> findAllJobs();

    void clearJobs();
}
