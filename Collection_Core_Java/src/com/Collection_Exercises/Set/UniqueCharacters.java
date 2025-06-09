package com.Collection_Exercises.Set;

import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueCharacters {
    public static void main(String[] args) {
        String str = "Programming";

        Set<Character> set = new LinkedHashSet<>();

        for(char c:str.toCharArray()){
            set.add(c);
        }
        StringBuilder br = new StringBuilder();
        for(char c:set){
            br.append(c);
        }
        System.out.println("String without duplicate: "+br);
    }
}
