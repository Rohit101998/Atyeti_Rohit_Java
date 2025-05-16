package Com.Rohit.DAO;

import Com.Rohit.Model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> loadEmployee();
    void saveEmployees(List<Employee> employees);
}
