package com.Collection_Exercises.Deep_Shallow_Copy;

//shallow and Deep Copy


public class Main {
    public static void main(String[] args) {
        Address address = new Address("Delhi");
        Employee emp1 = new Employee("Alice", address);

        Employee shallow = emp1.shallowCopy();
        shallow.setCity("Mumbai");

        System.out.println("Original after shallow copy change: " + emp1);
        System.out.println("Shallow copy: " + shallow);

        emp1.setCity("Delhi"); // Reset

        Employee deep = emp1.deepCopy();
        deep.setCity("Chennai");

        System.out.println("\n Original after deep copy change: " + emp1);
        System.out.println("Deep copy: " + deep);



    }
}
