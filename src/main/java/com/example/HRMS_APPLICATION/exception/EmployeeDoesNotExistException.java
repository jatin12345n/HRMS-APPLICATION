package com.example.HRMS_APPLICATION.exception;

public class EmployeeDoesNotExistException extends RuntimeException{
    public EmployeeDoesNotExistException(String message){
        super(message);
    }
}
