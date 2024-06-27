package com.example.HRMS_APPLICATION.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "payslipId")
public class Payslip {

    @NotNull
    @NotEmpty(message = "payslipId Id cannot be empty")
    private String payslipId;
    @NotNull
    @NotEmpty(message = "Employee Name cannot be empty")
    private String employeeName;
    @NotNull
    @NotEmpty(message = "Amount cannot be empty")
    private BigDecimal amount;

    public Payslip(String payslipId) {
        this.payslipId = payslipId;

    }

    @JsonCreator
    public Payslip
            (@JsonProperty("payslipId") String payslipId,
             @JsonProperty("employeeName") String employeeName,
             @JsonProperty("amount") BigDecimal amount) {
        this.payslipId = payslipId;
        this.employeeName = employeeName;
        this.amount = amount;

    }}

