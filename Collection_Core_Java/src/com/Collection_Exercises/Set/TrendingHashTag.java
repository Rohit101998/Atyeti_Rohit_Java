package com.Collection_Exercises.Set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrendingHashTag {
    public static void main(String[] args) {
        List<String> list = List.of("#AI", "#Java", "#AI", "#OpenAI", "#Java", "#ML");

        Set<String> trending = new HashSet<>();
        for(String th:list){
            trending.add(th);
        }
        System.out.println("Current Trending HAshTag:");
        trending.forEach(System.out::println);
    }
}
