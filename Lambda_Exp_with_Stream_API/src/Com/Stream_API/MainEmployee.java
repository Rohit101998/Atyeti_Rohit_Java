package Com.Stream_API;

import java.util.*;

public class MainEmployee {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1,"Rohit","Pune",100));
        emp.add(new Employee(2,"Swapnil","Mumbai",300));
        emp.add(new Employee(3,"Shubham","Sangli",800));
        emp.add(new Employee(4,"Vishal","Tasgaon",100));
        emp.add(new Employee(5,"Pratik","Delhi",500));

        for(Employee em:emp){
            System.out.println(em);
        }

        System.out.println("*******************************************************************************");

        List<String> list1  = new ArrayList<>();
        list1.add("Rohit");
        list1.add("Soham");
        list1.add("Vihan");

        List<String> list2 = new ArrayList<>();
        list2.add("Jassika");
        list2.add("Muskan");
        list2.add("Sejal");

        List<List<String>> l1 = new ArrayList<>();
        l1.add(list1);
        l1.add(list2);

        l1.stream().flatMap(Collection::stream).forEach(x-> System.out.println(x));




        System.out.println("*******************************************************************************");

        List<Integer> m1 = new ArrayList<>();
        m1.add(300);
        m1.add(500);
        m1.add(300);
        m1.add(400);
        m1.add(100);

        System.out.println("Arraylist in descending order:");

        m1.stream().sorted(Collections.reverseOrder()).forEach(x-> System.out.println(x));

        System.out.println("*******************************************************************************");

        System.out.println("Arraylist in ascending order: ");

        m1.stream().sorted().forEach(x->System.out.println(x));

        System.out.println("*******************************************************************************");

        //to print unique list

        System.out.println("Unique list is:");

        m1.stream().sorted().distinct().forEach(x-> System.out.println(x));

        System.out.println("*******************************************************************************");

        //to print hole list that name

        System.out.println("To print hole list that name:");

        emp.stream().filter(c->c.getName().startsWith("R")).forEach(x-> System.out.println(x));


        System.out.println("*******************************************************************************");

        //to print particular name
        System.out.println("To print perticuler name");

        emp.stream().filter(c->c.getName().startsWith("R")).forEach(x-> System.out.println(x.getName()));


        System.out.println("*******************************************************************************");

        System.out.println("TO print name in separate list:");

        emp.stream().map(c->c.getName()).forEach(x-> System.out.println(x));


        System.out.println("*******************************************************************************");

        System.out.println("Whose getting minimum salary");

        Employee employee = emp.stream().min((m, n) -> m.getSalary() - n.getSalary()).get();

        System.out.println("Employee name is:"+employee.getName());
        System.out.println("Employee salary is:"+employee.getSalary());

        System.out.println("*******************************************************************************");

        //employee list sorted on basis of salary
        System.out.println("Employee list sorted in basis of salary:");

        emp.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(c->System.out.println(c.getName()+": $"+c.getSalary()));


        System.out.println("*******************************************************************************");

    }
}
