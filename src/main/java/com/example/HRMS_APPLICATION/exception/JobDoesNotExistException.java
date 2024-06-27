package com.example.HRMS_APPLICATION.exception;

public class JobDoesNotExistException extends RuntimeException{
    public JobDoesNotExistException(String message){
        super(message);
    }
}
