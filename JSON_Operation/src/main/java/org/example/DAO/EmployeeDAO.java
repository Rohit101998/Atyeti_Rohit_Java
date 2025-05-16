package org.example.DAO;

import org.example.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> loadEmployee();
    void saveEmployees(List<Employee> employees);

}
