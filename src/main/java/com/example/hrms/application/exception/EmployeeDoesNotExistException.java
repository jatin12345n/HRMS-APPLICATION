package com.example.hrms.application.exception;

public class EmployeeDoesNotExistException extends RuntimeException{
    public EmployeeDoesNotExistException(String message){
        super(message);
    }
}
