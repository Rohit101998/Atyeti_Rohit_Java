package com.Collection_Exercises.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SortMapBy_Values {
    public static void main(String[] args) {
        Map<String,Integer> map = Map.of(
               "Apple",100,
                "Banana",40,
                "Grapes", 150

        );

        List<Map.Entry<String,Integer>> sortlist = new ArrayList<>(map.entrySet());

        sortlist.sort((a,b)->b.getValue().compareTo(a.getValue()));

        for(Map.Entry<String,Integer> entry:sortlist){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}
