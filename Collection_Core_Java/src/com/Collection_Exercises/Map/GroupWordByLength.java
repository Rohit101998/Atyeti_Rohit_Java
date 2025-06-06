package com.Collection_Exercises.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupWordByLength {
    public static void main(String[] args) {
        List<String> words =List.of("apple", "ball", "car", "ant", "air", "banana");

        Map<Integer,List<String>>  group = new HashMap<>();

        for(String word:words){
            group.computeIfAbsent(word.length(),k->new ArrayList<>()).add(word);
        }
        group.forEach((len,grop)->
                System.out.println("Length: "+len+" : "+grop));
    }
}
