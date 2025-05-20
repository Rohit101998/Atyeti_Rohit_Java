package com.collection_Student_Management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentApp {
    public static void main(String[] args) {

        //1. add Student List

        List<Student> list  = new ArrayList<>();
        list.add(new Student(1,"Rohit","Pune",98));
        list.add(new Student(2,"Sumit","Mumbai",99));
        list.add(new Student(3,"Shubham","Ratnagiri",95));
        list.add(new Student(4,"Lokesh","Nashik",95));
        list.add(new Student(5,"Pranav","Pune",99));
        list.add(new Student(6,"Sejal","Delhi",91));
        list.add(new Student(7,"Jasica","Pune",96));


        System.out.println("======================================================");
        //2. Sort by mark (Descending)

        list.stream().sorted(Comparator.comparingDouble(Student::getMarks).reversed()).forEach(System.out::println);

        System.out.println("=======================================================");

        //3.Find student with marks above 95

        list.stream().filter(stu->stu.getMarks()>95).forEach(System.out::println);

        System.out.println("========================================================");

        //4. Remove student with mark below 40

//        Iterator<Student> itr = list.listIterator();
//        while(itr.hasNext()){
//            if(itr.next().getMarks()<40){
//                itr.remove();
//            }
//        }
//        //print remaning student
//        System.out.println("\n Remening Student is: "+list);

        //or

        list.removeIf(student -> student.getMarks()<95);


        System.out.println("=====================================================");

        //5.Display all current student

        list.forEach(System.out::println);

    }

}
