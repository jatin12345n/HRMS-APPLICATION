package com.example.HRMS_APPLICATION.service;

import com.example.HRMS_APPLICATION.domain.Employee;
import com.example.HRMS_APPLICATION.repository.EmployeeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
