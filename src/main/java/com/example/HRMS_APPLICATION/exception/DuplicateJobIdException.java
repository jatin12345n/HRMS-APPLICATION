package com.example.HRMS_APPLICATION.exception;

public class DuplicateJobIdException extends RuntimeException{
    public DuplicateJobIdException(String message){
        super(message);
    }
}
