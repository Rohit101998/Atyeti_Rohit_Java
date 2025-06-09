package com.Collection_Exercises.Set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstRepeatedProduct {
    public static void main(String[] args) {
        List<String> list = List.of("Shoes", "Watch", "Bag", "Shoes", "Socks", "Bag");

        Set<String> set = new HashSet<>();

        for(String pr:list){
            if(!set.add(pr)){
                System.out.println("First repeated product is: "+pr);
                break;
            }
        }
    }
}
