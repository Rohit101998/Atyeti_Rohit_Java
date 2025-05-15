package org.example.Service;

import org.example.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void addEmployee(Employee employee);
    Optional<Employee> getEmployeeById(int id);
    void updateEmployee(int id,String name, String department,double salary);
    void removeEmployee(int id);
    List<Employee> filterBySalary(double minSalary);
    List<Employee> searchByName(String keyword);
    List<Employee> sortBySalary(boolean ascending);
    void displayEmployee();


}
