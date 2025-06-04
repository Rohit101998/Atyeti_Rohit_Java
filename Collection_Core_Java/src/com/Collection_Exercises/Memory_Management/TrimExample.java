package com.Collection_Exercises.Memory_Management;

import java.util.ArrayList;

public class TrimExample {
    public static void main(String[] args) {


            ArrayList<String> fruits = new ArrayList<>(10); // Capacity is 10

            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Mango");

            System.out.println("Size before trimToSize(): " + fruits.size());

            fruits.trimToSize();

            System.out.println("Size after trimToSize(): " + fruits.size());

            System.out.println("Fruits in the list:");
            for (String fruit : fruits) {
                System.out.println(fruit);
            }
        }
    }

