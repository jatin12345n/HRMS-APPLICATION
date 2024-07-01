package com.example.hrms.application.service;

import com.example.hrms.application.repository.EmployeeRepository;
import com.example.hrms.application.domain.Employee;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Getter
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void createEmployee(Employee employee) {
         this.employeeRepository.createEmployee(employee);
    }

    public Employee getEmployee(String employeeId) {
        return this.employeeRepository.getAccount(employeeId);
    }
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAllEmployee();
    }

    public Employee updateEmployee(String employeeId, Map<String, Object> updates) {
        return this.employeeRepository.updateEmployee(employeeId,updates);
    }

    public void deleteEmployee(String employeeId) {
        this.employeeRepository.deleteEmployee(employeeId);
    }
}
