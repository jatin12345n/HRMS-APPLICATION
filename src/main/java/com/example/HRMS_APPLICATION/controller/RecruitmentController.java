package com.example.HRMS_APPLICATION.controller;

import com.example.HRMS_APPLICATION.model.Application;
import com.example.HRMS_APPLICATION.model.Job;
import com.example.HRMS_APPLICATION.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return recruitmentService.getAllJobs();
    }

    @PostMapping("/jobs")
    public Job createJob(@RequestBody Job job) {
        return recruitmentService.createJob(job);
    }

    @GetMapping("/applications")
    public List<Application> getAllApplications() {
        return recruitmentService.getAllApplications();
    }

    @PostMapping("/applications")
    public Application createApplication(@RequestBody Application application) {
        return recruitmentService.createApplication(application);
    }}

