package com.example.HRMS_APPLICATION.exception;

public class DuplicateEmployeeIdException extends RuntimeException{
    public DuplicateEmployeeIdException(String message){
        super(message);
    }
}
