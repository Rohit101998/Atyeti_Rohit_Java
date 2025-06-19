package com.Custom_Exception.exception;

public class DatabaseWriteException extends AppException{
    public DatabaseWriteException(String msg,Throwable e){
        super(msg,e);
    }
}
