package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.domain.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayslipRepository{
    void createPayslip(Payslip payslip);

    Payslip getPayslip(String payslipId);

    List<Payslip> findAllPayslip();

    void clearPayslips();

}
