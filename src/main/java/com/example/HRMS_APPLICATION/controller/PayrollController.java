package com.example.HRMS_APPLICATION.controller;

import com.example.HRMS_APPLICATION.model.Payslip;
import com.example.HRMS_APPLICATION.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @GetMapping("/payslips")
    public List<Payslip> getAllPayslips() {
        return payrollService.getAllPayslips();
    }

    @PostMapping("/payslips")
    public Payslip createPayslip(@RequestBody Payslip payslip) {
        return payrollService.createPayslip(payslip);
    }}