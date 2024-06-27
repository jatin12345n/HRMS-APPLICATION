package com.example.HRMS_APPLICATION.controller;

import com.example.HRMS_APPLICATION.domain.Payslip;
import com.example.HRMS_APPLICATION.service.PayrollService;
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

@RestController
@RequestMapping("/api/payroll")
@Api(value = "Payroll API",description = "Used to adding information about payroll in HRMS")
@Slf4j
public class PayrollController {

    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }


    @ApiOperation(value = "Create a payslip", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Payslip created successfully"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPayslip(@RequestBody @Valid Payslip payslip) {
        log.info("Creating payslip {}", payslip);

        payrollService.createPayslip(payslip);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get an Payslip by payslip id", response = Payslip.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Payslip"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Account not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping(path = "/{payslipId}")
    public Payslip getPayslip(@PathVariable String payslipId){
        log.info("Retrieving payslip for id {}",payslipId);
        return this.payrollService.getPayslip(payslipId);

    }




    @ApiOperation(value = "Get all payslips", response = Payslip.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all accounts"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping
    public List<Payslip> getAllPayslips() {
      log.info("Retrieving all payslips");
      return this.payrollService.getAllPayslips();
    }

}