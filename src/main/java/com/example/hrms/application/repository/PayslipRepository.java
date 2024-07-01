package com.example.hrms.application.repository;

import com.example.hrms.application.domain.Job;
import com.example.hrms.application.domain.Payslip;

import java.util.List;
import java.util.Map;

public interface PayslipRepository {
    void createPayslip(Payslip payslip);

    Payslip getPayslip(String payslipId);

    List<Payslip> findAllPayslip();

    void clearPayslips();

    Payslip updatePayroll(String payslipId, Map<String, Object> updates);

    void deletePayroll(String payslipId);
}
