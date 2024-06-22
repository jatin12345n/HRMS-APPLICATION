package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
