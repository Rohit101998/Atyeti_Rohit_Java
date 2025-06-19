package com.Custom_Exception.Controller;

import com.Custom_Exception.exception.*;
import com.Custom_Exception.service.UserService;
import com.Custom_Exception.util.LoggerUtil;

public class UserController {
    private final UserService service = new UserService();

    public void register(String username, String email) {
        try {
            service.registerUser(username, email);
            System.out.println("Registration successful for: " + username);
        }
        catch (EmptyFieldException | InvalidEmailException | InvalidUsernameLengthException e) {
            System.err.println("Input Error: " + e.getMessage());
            LoggerUtil.log("WARN", e.getMessage());
        }
        catch (UserAlreadyExistException e) {
            System.err.println("Duplicate Error: " + e.getMessage());
            LoggerUtil.log("INFO", e.getMessage());
        }
        catch (DatabaseWriteException e) {
            System.err.println("DB Error: " + e.getMessage());
            LoggerUtil.log("ERROR", "Cause: " + e.getCause().getMessage());
        }
        catch (AppException e) {
            System.err.println("Application Error: " + e.getMessage());
            LoggerUtil.log("ERROR", "AppException: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
            LoggerUtil.log("FATAL", "Unexpected exception: " + e);
        }
        finally {
            LoggerUtil.log("INFO", "Attempted registration for user: " + username);
        }
    }
}
