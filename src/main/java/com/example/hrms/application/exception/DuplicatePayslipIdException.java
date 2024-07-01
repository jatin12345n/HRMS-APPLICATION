package com.example.hrms.application.exception;

public class DuplicatePayslipIdException extends RuntimeException{
    public DuplicatePayslipIdException(String message){
        super(message);
    }
}
