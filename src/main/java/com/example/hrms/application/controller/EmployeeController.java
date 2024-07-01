package com.example.hrms.application.controller;

import com.example.hrms.application.domain.Employee;
import com.example.hrms.application.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@Api(value = "Employee API", description = "Used to adding information about employees in HRMS")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @ApiOperation(value = "Create an Employee", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee created successfully"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid Employee employee) {
        log.info("Creating Employee {}", employee);
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @ApiOperation(value = "Get an Employee by Employee id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Employee"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Employee not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping(path = "/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        log.info("Retrieving Employee for id {}", employeeId);
        return this.employeeService.getEmployee(employeeId);
    }


    @ApiOperation(value = "Get all Employees", response = Employee.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Employee"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("retrieving all employees");
        return employeeService.getAllEmployees();
    }

    @ApiOperation(value = "Update an Employee by employee Id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the Employee details"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Employee not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PatchMapping(path = "/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@PathVariable String employeeId, @RequestBody Map<String, Object> updates) {
        log.info("Updating Employee details for id {}", employeeId);
        return employeeService.updateEmployee(employeeId, updates);
    }

    @ApiOperation(value = "Delete an Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted an Employee"),
            @ApiResponse(code = 404, message = "The Employee you were trying to delete is not found")
    })
    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        log.info("Deleting Employee with id: {}", employeeId);
        employeeService.deleteEmployee(employeeId);
    }

}