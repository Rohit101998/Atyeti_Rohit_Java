package Com.Rohit;

import Com.Rohit.Exception.DuplicateEmployeeException;
import Com.Rohit.Model.Employee;
import Com.Rohit.Service.EmployeeService;
import Com.Rohit.Service.IMPL.EmployeeServiceIMPL;
import Com.Rohit.Util.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceIMPL();

        while(true){
            System.out.println("\n====== Employee Management System ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Remove Employee");
            System.out.println("6. Filter Employee by Salary");
            System.out.println("7. Search Employee by Name");
            System.out.println("8. Sort Employee by Salary");
            System.out.println("9. Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Department: ");
                    String department = sc.nextLine();
                    System.out.println("Enter Salary: ");
                    double salary = sc.nextDouble();
                    try {
                        employeeService.addEmployee(new Employee(id, name, department, salary));
                    }catch (DuplicateEmployeeException e)
                    {
                        System.out.println("The Employee With Id is Already Exist");
                    }
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.println("\n---- Employee List ----");
                    employeeService.displayEmployee();
                    break;

                case 3:
                    System.out.println("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();

                    employeeService.getEmployeeByID(searchId).ifPresentOrElse(
                            System.out::println,
                            ()-> System.out.println("Employee Not Found!")
                    );

                    break;

                case 4:
                    System.out.println("Enter employee Id to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Name: ");
                    String newName = sc.nextLine();
                    System.out.println("Enter Department: ");
                    String newDepartment =sc.nextLine();
                    System.out.println("Enter Salary: ");
                    double newSalary = sc.nextDouble();

                    employeeService.updateEmployee(updateId, newName, newDepartment,newSalary);
                    System.out.println("Employee Updated Successfully!");
                    break;

                case 5:
                    System.out.println("Enter Employee ID to remove: ");
                    int removed =sc.nextInt();
                    employeeService.removeEmployee(removed);
                    System.out.println("Employee Removed Successfully!");
                    break;

                case 6:
                    System.out.println("Enter minimum salary to filter: ");
                    double minSalary = sc.nextDouble();
                    employeeService.filterBySalary(minSalary)
                            .forEach(System.out::println);

                    break;

                case 7:
                    System.out.println("Enter name keyword to search: ");
                    String keyword = sc.nextLine();
                    employeeService.searchByName(keyword)
                            .forEach(System.out::println);
                    break;

                case 8:
                    System.out.println("Sort by salary ?(true for ascending, false for descending): ");
                    boolean ascending = sc.nextBoolean();
                    employeeService.sortBySalary(ascending).forEach(System.out::println);
                    break;

                case 9:
                    System.out.println("Exiting the system");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!Please try again!");


            }
        }
    }
}
