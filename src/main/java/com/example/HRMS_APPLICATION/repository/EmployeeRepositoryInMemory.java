package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.domain.Employee;
import com.example.HRMS_APPLICATION.exception.DuplicateEmployeeIdException;
import com.example.HRMS_APPLICATION.exception.EmployeeDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployeeRepositoryInMemory implements EmployeeRepository {

    private final Map<String, Employee> employeeMap = new ConcurrentHashMap<>();

    @Override
    public void createEmployee(Employee employee) throws DuplicateEmployeeIdException {
        Employee previousEmployee = employeeMap.putIfAbsent(employee.getEmployeeId(), employee);
        if (previousEmployee != null) {
            throw new DuplicateEmployeeIdException("Employee id" + employee.getEmployeeId() + "already exists");
        }
    }

    @Override
    public Employee getAccount(String employeeId) {
        if (employeeMap.containsKey(employeeId)){
            return employeeMap.get(employeeId);
        }else{
            throw new EmployeeDoesNotExistException("Employee is not found");
        }
    }


    @Override
    public List<Employee> findAllEmployee() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public void clearEmployees() {
        employeeMap.clear();
    }


}
