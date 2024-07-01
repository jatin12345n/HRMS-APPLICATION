package com.example.hrms.application.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = "applicationId")
public class Application {

    @NotNull
    @NotEmpty(message = "Application ID cannot be empty")
    private final String applicationId;

    @NotNull
    @NotEmpty(message = "Applicant name cannot be empty")
    private String applicantName;

    @NotNull
    @NotEmpty(message = "Job title cannot be empty")
    private String jobTitle;

    public Application(String applicationId) {
        this.applicationId = applicationId;
    }

    @JsonCreator
    public Application(@JsonProperty("applicationId") String applicationId,
                       @JsonProperty("applicantName") String applicantName,
                       @JsonProperty("jobTitle") String jobTitle) {
        this.applicationId = applicationId;
        this.applicantName = applicantName;
        this.jobTitle = jobTitle;
    }

}

