package com.example.HRMS_APPLICATION.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = "jobId")

public class Job {
    @NotNull
    @NotEmpty(message = "Job ID cannot be empty")
    private String jobId;
    @NotNull
    @NotEmpty(message = "Job title cannot be empty")
    private String title;
    @NotNull
    @NotEmpty(message = "Job description cannot be empty")
    private String description;

    public Job(String jobId) {
        this.jobId = jobId;
    }

    @JsonCreator
    public Job
            (@JsonProperty("jobId") String jobId,
             @JsonProperty("title") String title,
             @JsonProperty("description") String description) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;

    }
}


