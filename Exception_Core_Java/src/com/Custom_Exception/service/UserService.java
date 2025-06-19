package com.Custom_Exception.service;

import com.Custom_Exception.dao.UserDAO;
import com.Custom_Exception.exception.*;
import com.Custom_Exception.module.User;


public class UserService  {
    private final UserDAO dao = new UserDAO();

    public void registerUser(String username, String email) throws AppException, UserAlreadyExistException {
        if (username == null || username.isBlank()) {
            throw new EmptyFieldException("Username cannot be empty.");
        }

        if (username.length() < 3) {
            throw new InvalidUsernameLengthException("Username must be at least 3 characters.");
        }

        if (email == null || !email.matches(".+@.+\\..+")) {
            throw new InvalidEmailException("Invalid email format.");
        }

        User user = new User(username, email);
        dao.save(user);

    }
}
