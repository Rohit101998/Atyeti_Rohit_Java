package com.Custom_Exception.exception;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String msg){
        super(msg);
    }

}
