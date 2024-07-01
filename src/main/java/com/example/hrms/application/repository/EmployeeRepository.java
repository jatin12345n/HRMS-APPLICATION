package com.example.hrms.application.repository;

import com.example.hrms.application.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    void createEmployee(Employee employee);

    Employee getAccount(String employeeId);

    List<Employee> findAllEmployee();

    void clearEmployees();

    Employee updateEmployee(String employeeId, Map<String, Object> updates);

    void deleteEmployee(String employeeId);
}
