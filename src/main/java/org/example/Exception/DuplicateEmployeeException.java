package org.example.Exception;

public class DuplicateEmployeeException extends RuntimeException{
    public DuplicateEmployeeException(String message){
        super(message);
    }
}
