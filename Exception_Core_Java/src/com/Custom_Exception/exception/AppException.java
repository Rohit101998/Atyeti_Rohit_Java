package com.Custom_Exception.exception;

public class AppException extends Exception{
    public AppException(String message){
        super(message);
    }
    public AppException(String message, Throwable cause){
        super(message,cause);
    }

}
