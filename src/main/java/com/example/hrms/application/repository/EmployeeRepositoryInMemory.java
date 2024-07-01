package com.example.hrms.application.repository;

import com.example.hrms.application.domain.Employee;
import com.example.hrms.application.exception.DuplicateEmployeeIdException;
import com.example.hrms.application.exception.EmployeeDoesNotExistException;
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
        if (employeeMap.containsKey(employeeId)) {
            return employeeMap.get(employeeId);
        } else {
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

    @Override
    public Employee updateEmployee(String employeeId, Map<String, Object> updates) {
        Employee employee = employeeMap.get(employeeId);
        if (employee == null) {
            throw new EmployeeDoesNotExistException("Employee not found with id " + employeeId);
        }
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    employee.setName((String) value);
                    break;
                case "email":
                    employee.setEmail((String) value);
                    break;
                case "department":
                    employee.setDepartment((String) value);
                    break;
            }
        });
        employeeMap.put(employeeId, employee);
        return employee;
    }

    @Override
    public void deleteEmployee(String employeeId) {
        employeeMap.remove(employeeId);
    }


}
