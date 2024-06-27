package com.example.HRMS_APPLICATION.exception;

public class DuplicatePayslipIdException extends RuntimeException{
    public DuplicatePayslipIdException(String message){
        super(message);
    }
}
