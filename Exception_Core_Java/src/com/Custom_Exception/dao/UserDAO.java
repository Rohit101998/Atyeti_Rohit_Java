package com.Custom_Exception.dao;

import com.Custom_Exception.exception.DatabaseWriteException;
import com.Custom_Exception.exception.UserAlreadyExistException;
import com.Custom_Exception.module.User;

import java.util.HashSet;
import java.util.Set;

public class UserDAO {
    private static final Set<String> Db = new HashSet<>();

    public void save(User user)throws UserAlreadyExistException, DatabaseWriteException{
        if(Db.contains(user.getUsername())){
            throw new UserAlreadyExistException("User already exist: "+user.getUsername());

        }
        try{
            if(user.getUsername().equalsIgnoreCase("dbfail")){
                throw new RuntimeException("Simulated DB write error");
            }
            Db.add(user.getUsername());
        }catch (RuntimeException e){
            throw new DatabaseWriteException("Database error",e);
        }
    }
}
