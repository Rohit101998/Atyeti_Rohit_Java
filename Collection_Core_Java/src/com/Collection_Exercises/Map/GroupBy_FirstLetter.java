package com.Collection_Exercises.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupBy_FirstLetter {
    public static void main(String[] args) {
        List<String> names = List.of("Rohit","Pratik","Ram","Swapnil");

        Map<Character, List<String>> group = new HashMap<>();

        for(String name:names){
            char first = name.charAt(0);
             group.computeIfAbsent(first, k -> new ArrayList<>()).add(name);

        }

        System.out.println(group);
    }

}
