package com.example.HRMS_APPLICATION.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = "employeeId")
public class Employee {


    @NotNull
    @NotEmpty(message = "Employee ID cannot be empty")
    private final String employeeId;

    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull
    @NotEmpty(message = "email cannot be empty")
    private String email;

    @NotNull
    @NotEmpty(message = "Department cannot be empty")
    private String department;


    public Employee(String employeeId) {
        this.employeeId = employeeId;

    }

    @JsonCreator
    public Employee
            (@JsonProperty("employeeId") String employeeId,
             @JsonProperty("name") String name,
             @JsonProperty("email") String email,
             @JsonProperty("department")String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.department = department;
    }
}
