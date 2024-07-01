package com.example.hrms.application.exception;

public class PayslipDoesNotExistException extends RuntimeException{
    public PayslipDoesNotExistException(String message){
        super(message);
    }
}
