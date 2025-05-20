package com.collection_Employee_Payroll;

import java.util.*;
import java.util.stream.Collectors;

public class Payrollapp {
    public static void main(String[] args) {

        //1. Add Employee

        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "Rohit", "MCA", 500000.00));
        emp.add(new Employee(2, "shubham", "IT", 600000.00));
        emp.add(new Employee(3, "Sumit", "CS", 800000.00));
        emp.add(new Employee(4, "Swapnil", "IT", 900000.00));
        emp.add(new Employee(5, "Pratik", "CS", 900000.00));
        emp.add(new Employee(6, "Sejal", "CS", 700000.00));
        emp.add(new Employee(7, "Muskan", "MCA", 400000.00));

        //2.Calculate total and average salary
        long count = emp.stream().sorted().count();
        System.out.println("Count of Salary is: " + count);

        double sum = emp.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Sum of Salary: " + sum);

        OptionalDouble average = emp.stream().mapToDouble(Employee::getSalary).average();
        System.out.println("Average salary is: " + average);

        //or

//        double averageSalary = sum/count;
//        System.out.println("Average salary is: "+averageSalary);

        System.out.println("==================================================");

        //3.Display employee with salary 500000

        emp.stream().filter(employee -> employee.getSalary()>500000.00).forEach(System.out::println);

        System.out.println("=======================================================");

        //4. Employee with the highest salary

        Optional<Employee> max = emp.stream().max(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("The max Salary is :"+max);

        //or

//        Optional<Employee> first = emp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
//
//        System.out.println("The max Salary is: "+first);

        System.out.println("=========================================================");

        //5. Group employee by department

        Map<String, List<Employee>> collect = emp.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        collect.forEach((dept,emplit)->{
            System.out.println("Department: "+dept);
            emplit.forEach(System.out::println);
        });
    }
}