package com.Collections_Methods;

import java.util.*;

public class CollectionsMethods {
    public static void main(String[] args) {
        //1. Searching and Sorting

        List<String> list =new ArrayList<>(Arrays.asList("Orange","Banana","Grapes","Apple","Mango"));

        Collections.sort(list);
        System.out.println("Sorted list: "+list);


        Collections.sort(list,Collections.reverseOrder());
        System.out.println("Reversed order: "+list);

        int index = Collections.binarySearch(list,"Mango");
        System.out.println("Binary search for mango: "+index);


        //Shuffling Reverse Swapping

        List<String> list1 = new ArrayList<>(Arrays.asList("A","B","C","D"));

        Collections.shuffle(list1);
        System.out.println("Shuffled: "+list1);

        Collections.reverse(list1);
        System.out.println("Reversed: "+list1);

        Collections.swap(list1,0,2);
        System.out.println("After swap: "+list1);

        //Frequency , Min, Max, ReplaceALL,Fill

        List<String> items = Arrays.asList("Apple","Banana","Apple","Chery");

        int freq = Collections.frequency(items,"Apple");
        System.out.println("Frequency of Apple: "+freq);

        String min =Collections.min(items);
        System.out.println("Min: "+min);

        String max = Collections.max(items);
        System.out.println("Max: "+max);

        List<String> mt = new ArrayList<>(items);
        Collections.replaceAll(mt,"Apple","Pineapple");
        System.out.println("After replace: "+mt);

        Collections.fill(mt,"Filled");
        System.out.println("After fill: "+mt);

        //Copy
        List<String> src =Arrays.asList("X","Y","Z");
        List<String> dest = new ArrayList<>(Arrays.asList("1","2","3"));

        Collections.copy(dest,src);
        System.out.println("After Copy: "+dest);

        // Synchronized Collection

        List<String> syncLIST = Collections.synchronizedList(new ArrayList<>());
        Set<String> syncSET = Collections.synchronizedSet(new HashSet<>());
        Map<String,Integer> syncMAP= Collections.synchronizedMap(new HashMap<>());

        syncLIST.add("Rohit");
        System.out.println("Synchronised list: "+syncLIST);

        //Read Only
        List<String> original = new ArrayList<>(Arrays.asList("A","B"));
        List<String> read = Collections.unmodifiableList(original);

        System.out.println("Unmodifiable list: "+read);

        //Singleton, Empty, Checked Collections

        List<String> singleton = Collections.singletonList("OnlyOne");
        System.out.println("Singleton List: "+singleton);

        List<String> empty = Collections.emptyList();
        System.out.println("Empty List: " + empty);

        List rawList = new ArrayList(); // unchecked type
        List<String> checkedList = Collections.checkedList(rawList, String.class);
        checkedList.add("TypeSafe");
        System.out.println("Checked List: " + checkedList);

    }
}
