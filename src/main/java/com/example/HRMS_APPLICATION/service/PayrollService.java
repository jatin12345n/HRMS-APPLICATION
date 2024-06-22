package com.example.HRMS_APPLICATION.service;

import com.example.HRMS_APPLICATION.model.Payslip;
import com.example.HRMS_APPLICATION.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {
    @Autowired
    private PayslipRepository payslipRepository;

    public List<Payslip> getAllPayslips() {
        return payslipRepository.findAll();
    }

    public Payslip createPayslip(Payslip payslip) {
        return payslipRepository.save(payslip);
    }}
