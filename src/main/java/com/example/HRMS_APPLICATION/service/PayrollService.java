package com.example.HRMS_APPLICATION.service;

import com.example.HRMS_APPLICATION.domain.Payslip;
import com.example.HRMS_APPLICATION.repository.PayslipRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {
    @Getter
    private final PayslipRepository payslipRepository;
    @Autowired
    public PayrollService(PayslipRepository payslipRepository) {
        this.payslipRepository = payslipRepository;
    }


    public void createPayslip(Payslip payslip) {
         this.payslipRepository.createPayslip(payslip);
    }


    public List<Payslip> getAllPayslips() {
        return this.payslipRepository.findAllPayslip();
    }



    public Payslip getPayslip(String payslipId) {
        return this.payslipRepository.getPayslip(payslipId);
    }
}
