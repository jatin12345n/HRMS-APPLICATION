package com.example.hrms.application.exception;

public class DuplicateJobIdException extends RuntimeException{
    public DuplicateJobIdException(String message){
        super(message);
    }
}
