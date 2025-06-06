package com.Collection_Exercises.Map;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FrequencySort {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 5, 4, 3};


        Map<Integer, Integer> map = new HashMap<>();
        for (Integer in : arr) {
           if(map.containsKey(in)){
               map.put(in,map.get(in)+1);
           }else {
               map.put(in,1);
           }
        }
        Stream<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());
       sorted.forEach(e-> System.out.println(e.getKey()+" : "+e.getValue()));
    }
}
