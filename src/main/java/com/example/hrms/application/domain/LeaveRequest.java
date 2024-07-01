package com.example.hrms.application.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data

@EqualsAndHashCode(of = "LeaveRequestId")
public class LeaveRequest {
    @NotNull
    @NotEmpty(message = "LeaveRequest ID cannot be empty")
    private String leaveRequestId;
    @NotNull
    @NotEmpty(message = "Employee Name cannot be empty")
    private String employeeName;
    @NotNull
    @NotEmpty(message = "start Date cannot be empty")
    private LocalDate startDate;
    @NotNull
    @NotEmpty(message = "End Date cannot be empty")
    private LocalDate endDate;

    public LeaveRequest(String leaveRequestId) {
        this.leaveRequestId = leaveRequestId;

    }

    @JsonCreator
    public LeaveRequest
            (@JsonProperty("leaveRequestId") String leaveRequestId,
             @JsonProperty("employeeName") String employeeName,
             @JsonProperty("startDate") LocalDate startDate,
             @JsonProperty("endDate") LocalDate endDate) {
        this.leaveRequestId = leaveRequestId;
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}