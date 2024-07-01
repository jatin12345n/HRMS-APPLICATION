package com.example.hrms.application.exception;

public class LeaveRequestDoesNotExistException extends RuntimeException{
    public LeaveRequestDoesNotExistException(String message){
        super(message);
    }
}
