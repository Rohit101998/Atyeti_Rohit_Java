package com.Collection_Exercises;

import java.util.*;

public class Second_Most_Frequent {
    public static int secondMostFrequent(List<Integer> list){
       Map<Integer,Integer> friqMap = new HashMap<>();
       for(int num:list){
           friqMap.put(num,friqMap.getOrDefault(num,0)+1);
       }
       List<Map.Entry<Integer,Integer>> listMap = new ArrayList<>(friqMap.entrySet());
       listMap.sort((a,b)->b.getValue() - a.getValue());
       return listMap.get(1).getKey();
    }
    public static void main(String[] args) {
        List<Integer>list =Arrays.asList(1,2,2,3,3,3,2,2,1,1,1);
        int element= secondMostFrequent(list);
        System.out.println("Second most frequency element is: "+element);
    }
}
