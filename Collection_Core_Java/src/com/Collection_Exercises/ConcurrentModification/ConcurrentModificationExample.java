package com.Collection_Exercises.ConcurrentModification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Rohit");
        names.add("Shubhm");
        names.add("sumit");

//        Iterator<String> iterator = names.iterator();
//        while (iterator.hasNext()) {
//            String name = iterator.next();
//            if (name.equals("sumit")) {
//                names.remove(name);  //  Directly modifying the list
//            }
//        }

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("sumit")) {
                iterator.remove();  //   modifying the iterator
            }
        }
        System.out.println("Updated List: " + names);
    }
}
