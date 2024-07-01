package com.example.hrms.application.service;

import com.example.hrms.application.domain.Job;
import com.example.hrms.application.repository.PayslipRepository;
import com.example.hrms.application.domain.Payslip;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public Payslip updatePayroll(String payslipId, Map<String, Object> updates) {
        return this.payslipRepository.updatePayroll(payslipId,updates);
    }

    public void deletePayroll(String payslipId) {
        this.payslipRepository.deletePayroll(payslipId);
    }
}
