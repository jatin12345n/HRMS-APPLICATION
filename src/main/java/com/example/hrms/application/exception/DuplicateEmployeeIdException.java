package com.example.hrms.application.exception;

public class DuplicateEmployeeIdException extends RuntimeException{
    public DuplicateEmployeeIdException(String message){
        super(message);
    }
}
