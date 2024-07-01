package com.example.hrms.application.exception;

public class DuplicateLeaveRequestIdException extends RuntimeException{
    public DuplicateLeaveRequestIdException(String message){
        super(message);
    }
}
