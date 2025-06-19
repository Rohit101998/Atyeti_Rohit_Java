package com.Custom_Exception.exception;

public class InvalidEmailException extends AppException{
    public InvalidEmailException(String msg){
        super(msg);
    }
}
