package com.example.hrms.application.exception;

public class DuplicateApplicationIdException extends RuntimeException{
    public DuplicateApplicationIdException(String message){
        super(message);
    }
}
