package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.model.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayslipRepository extends JpaRepository<Payslip, Long> {
}
