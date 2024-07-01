package com.example.hrms.application.controller;

import com.example.hrms.application.domain.Application;
import com.example.hrms.application.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
@Api(value = "Application API", description = "Used to adding information about application in HRMS")
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @ApiOperation(value = "Creating an application", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Job Posted successfully"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createApplication(@RequestBody @Valid Application application) {
        log.info("Creating application {}", application);
        applicationService.createApplication(application);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get an application by application id", response = Application.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Application"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Account not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping(path = "/{applicationId}")
    public Application getApplication(@PathVariable String applicationId) {
        log.info("Retrieving Application for id {}", applicationId);
        return this.applicationService.getApplication(applicationId);
    }


    @ApiOperation(value = "Get all applications", response = Application.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Jobs"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping
    public List<Application> getAllApplications() {
        log.info("Retrieving all applications");
        return applicationService.getAllApplications();
    }

    @ApiOperation(value = "Update an application details by application id", response = Application.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the Application details"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Account not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PatchMapping(path = "/{applicationId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Application updateApplication(@PathVariable String applicationId, @RequestBody Map<String, Object> updates) {
        log.info("Updating Application details for id {}", applicationId);
        return this.applicationService.updateApplication(applicationId, updates);
    }

    @ApiOperation(value = "Delete an application")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted an application"),
            @ApiResponse(code = 404, message = "The application you were trying to delete is not found")
    })
    @DeleteMapping(path = "/{applicationId}")
    public void deleteApplication(@PathVariable String applicationId) {
        log.info("Deleting application with id: {}", applicationId);
        applicationService.deleteApplication(applicationId);
    }
}