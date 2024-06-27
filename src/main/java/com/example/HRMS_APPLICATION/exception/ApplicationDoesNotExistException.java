package com.example.HRMS_APPLICATION.exception;

public class ApplicationDoesNotExistException extends RuntimeException{
    public ApplicationDoesNotExistException(String message){
        super(message);
    }
}
