package org.example.Service.IMPL;

import org.example.DAO.EmployeeDAO;
import org.example.DAO.EmployeeJSON_IMPL;
import org.example.Entity.Employee;
import org.example.Exception.DuplicateEmployeeException;
import org.example.Exception.EmployeeNotFoundException;
import org.example.Service.EmployeeService;
import org.example.Util.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees;
    private EmployeeDAO employeeDAO;

    EmployeeServiceImpl(){
        this.employeeDAO = new EmployeeJSON_IMPL();
        this.employees = employeeDAO.loadEmployee();

    }

    @Override
    public void addEmployee(Employee employee) {
        if(getEmployeeById(employee.getId()).isPresent()){
            throw new DuplicateEmployeeException("Employee with id "+employee.getId()+" already exists.");
        }
        employees.add(employee);
        employeeDAO.saveEmployees(employees);
        Logger.log("Added  employee"+employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        Optional<Employee> first = employees.stream().filter(emp -> emp.getId() == id).findFirst();
        return first;
    }

    @Override
    public void updateEmployee(int id, String name, String department, double salary) {
        Employee emp = getEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + "not found"));

        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        employeeDAO.saveEmployees(employees);
        Logger.log ("Updated employee"+emp);
    }

    @Override
    public void removeEmployee(int id) {
        boolean removed = employees.removeIf(emp -> emp.getId() == id);

        if(!removed){
            throw new EmployeeNotFoundException("Employee with id "+ id+" not id");
        }
        employeeDAO.saveEmployees(employees);
        Logger.log("Removed employee with id: "+id);
    }

    @Override
    public List<Employee> filterBySalary(double minSalary) {

        return employees.stream().filter(emp->emp.getSalary()>minSalary)
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
