package Com.Rohit.Exception;

public class DuplicateEmployeeException extends RuntimeException {
    public DuplicateEmployeeException(String message){
        super(message);
    }
}
