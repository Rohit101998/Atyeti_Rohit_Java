package com.Collection_Exercises.Map;

import java.util.HashMap;
import java.util.Map;

public class Merge_Map {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 2, "B", 3);
        Map<String, Integer> map2 = Map.of("A", 4, "C", 5);

        Map<String, Integer> result = new HashMap<>(map1);

        map2.forEach((key, value) ->
                result.merge(key, value, Integer::sum)
        );

        System.out.println(result);
    }
}
