package com.Collection_Exercises.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class String_Duplicate_Count {
    public static void main(String[] args) {

        String a ="Programming";
        char b[] = a.toCharArray();

        Map<Character,Integer> charmap = new HashMap<>();

        for(char c:b){
            if(Character.isAlphabetic(c)){
                if(charmap.containsKey(c)){
                    charmap.put(c,charmap.get(c)+1);
                }else {
                    charmap.put(c, 1);

                }
            }
        }
        System.out.println(charmap);

        Stream<Map.Entry<Character, Integer>> sorted = charmap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed());
        sorted.forEach(c-> System.out.println(c.getKey()+" : "+c.getValue()));
    }
}
