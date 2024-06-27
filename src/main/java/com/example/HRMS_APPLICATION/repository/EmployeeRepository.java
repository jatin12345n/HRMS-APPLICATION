package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository{
    void createEmployee(Employee employee);
    Employee getAccount(String employeeId);

    List<Employee> findAllEmployee();

    void clearEmployees();
}
