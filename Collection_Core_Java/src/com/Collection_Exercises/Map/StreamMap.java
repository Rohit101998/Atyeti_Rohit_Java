package com.Collection_Exercises.Map;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<String> names = List.of("Apple","Banana","Orange");

        Map<String, Integer> collect = names.stream().collect(Collectors.toMap(
                name -> name,
                name -> name.length()
        ));

        collect.forEach((k,v)-> System.out.println(k+" : "+v));
    }
}
