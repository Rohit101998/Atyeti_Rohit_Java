package com.Collection_Exercises.Sublist;

import java.util.ArrayList;
import java.util.List;

public class SubListExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Rohit");
        list.add("Sumit");
        list.add("shubham");
        list.add("Pratik");
        list.add("Sourabh");

        List<String> sublist = list.subList(1,4);

        System.out.println("Sublist: "+sublist);

        sublist.set(1,"Swapnil");

        System.out.println("Modified sublist: "+sublist);
        System.out.println("Orignal List: "+list);

        List<String> mod = new ArrayList<>(sublist);

        mod.add("Pranav");
        mod.add("Lokesh");

        System.out.println("Updated sublist: "+mod);

        mod.remove("Pranav");

        System.out.println("Original List: "+list);

    }
}
