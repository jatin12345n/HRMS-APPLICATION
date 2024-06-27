package com.example.HRMS_APPLICATION.exception;

public class LeaveRequestDoesNotExistException extends RuntimeException{
    public LeaveRequestDoesNotExistException(String message){
        super(message);
    }
}
