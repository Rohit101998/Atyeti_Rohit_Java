package com.Collection_Exercises.Set;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class UniqueSubjectCombinations {
    public static void main(String[] args) {
        Map<String, Set<String>> studentSubjects = Map.of(
                "Alice", Set.of("Math", "Physics"),
                "Bob", Set.of("Physics", "Math"),
                "Charlie", Set.of("Chemistry", "Biology"),
                "David", Set.of("Biology", "Chemistry"),
                "Eva", Set.of("Math", "Physics", "Chemistry")
        );


        Set<Set<String>> uniqueSub = new LinkedHashSet<>();

        for(Set<String> subject:studentSubjects.values()){
            uniqueSub.add(subject);
        }

        System.out.println("The count of unique Subject: "+uniqueSub.size());

        System.out.println("Unique Sub Combination: ");

        for(Set<String> st:uniqueSub){
            System.out.println(st);
        }
    }
}
