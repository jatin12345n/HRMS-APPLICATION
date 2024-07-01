package com.example.hrms.application.exception;

public class ApplicationDoesNotExistException extends RuntimeException{
    public ApplicationDoesNotExistException(String message){
        super(message);
    }
}
