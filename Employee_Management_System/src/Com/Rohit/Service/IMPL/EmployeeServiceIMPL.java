package Com.Rohit.Service.IMPL;

import Com.Rohit.DAO.EmployeeDAO;
import Com.Rohit.DAO.EmployeeJSON_IMPL;
import Com.Rohit.Exception.DuplicateEmployeeException;
import Com.Rohit.Exception.EmployeeNotFoundException;
import Com.Rohit.Model.Employee;
import Com.Rohit.Service.EmployeeService;
import Com.Rohit.Util.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

public class EmployeeServiceIMPL implements EmployeeService {

    private List<Employee> employees;
    private EmployeeDAO employeeDAO;

    public EmployeeServiceIMPL(){
        this.employeeDAO= new EmployeeJSON_IMPL();
        this.employees = employeeDAO.loadEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        if(getEmployeeByID(employee.getId()).isPresent()){
            throw new    DuplicateEmployeeException("Employee with ID" + employee.getId()+"already exists.");
        }
        employees.add(employee);
        employeeDAO.saveEmployees(employees);
        Logger.log("Added employee: "+employee);
    }

    @Override
    public Optional<Employee> getEmployeeByID(int id) {
        Optional<Employee> first = employees.stream().filter(emp -> emp.getId() == id).findFirst();
        return first;
    }

    @Override
    public void updateEmployee(int id, String name, String department, double salary) {
        Employee emp = getEmployeeByID(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with ID" + id + "not found"));
        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        employeeDAO.saveEmployees(employees);
        Logger.log("Updated Employee: "+emp);
    }

    @Override
    public void removeEmployee(int id) {
        boolean removed = employees.removeIf(emp -> emp.getId() == id);

        if(!removed){
            throw new EmployeeNotFoundException("Employee with ID" + id +"not found.");
        }
        employeeDAO.saveEmployees(employees);
        Logger.log("Removed employee with Id: "+id);
    }

    @Override
    public List<Employee> filterBySalary(double minSalary) {
        return employees.stream().filter(emp->emp.getSalary() > minSalary)
                .collect(Collectors.toList());

    }

    @Override
    public List<Employee> searchByName(String keyword) {
        return employees.stream().filter(emp->emp.getName().toLowerCase()
                .contains(keyword.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortBySalary(boolean ascending) {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }

    @Override
    public void displayEmployee() {

        employees.forEach(System.out::println);

    }
}
