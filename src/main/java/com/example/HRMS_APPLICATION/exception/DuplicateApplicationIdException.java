package com.example.HRMS_APPLICATION.exception;

public class DuplicateApplicationIdException extends RuntimeException{
    public DuplicateApplicationIdException(String message){
        super(message);
    }
}
