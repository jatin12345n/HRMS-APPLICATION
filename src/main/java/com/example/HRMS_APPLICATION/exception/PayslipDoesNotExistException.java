package com.example.HRMS_APPLICATION.exception;

public class PayslipDoesNotExistException extends RuntimeException{
    public PayslipDoesNotExistException(String message){
        super(message);
    }
}
