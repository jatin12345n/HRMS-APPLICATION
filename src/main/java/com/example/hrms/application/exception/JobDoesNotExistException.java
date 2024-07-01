package com.example.hrms.application.exception;

public class JobDoesNotExistException extends RuntimeException{
    public JobDoesNotExistException(String message){
        super(message);
    }
}
