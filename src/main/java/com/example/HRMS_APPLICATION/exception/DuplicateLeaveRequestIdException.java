package com.example.HRMS_APPLICATION.exception;

public class DuplicateLeaveRequestIdException extends RuntimeException{
    public DuplicateLeaveRequestIdException(String message){
        super(message);
    }
}
