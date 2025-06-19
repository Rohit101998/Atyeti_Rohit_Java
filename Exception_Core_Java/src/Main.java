import com.Custom_Exception.Controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();

        controller.register("Rohit","rohitpatil@gmail.com");
        controller.register("ro", "short@example.com");
        controller.register("john", "invalidemail");
        controller.register("", "empty@example.com");
        controller.register("rohit", "again@example.com");
        controller.register("dbfail", "fail@db.com");

        System.out.println("End of registration process.");

    }
}