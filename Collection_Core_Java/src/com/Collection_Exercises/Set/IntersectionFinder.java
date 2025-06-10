package com.Collection_Exercises.Set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionFinder {
    public static void main(String[] args) {
        Set<Set<String>> allSets = Set.of(
                Set.of("a", "b", "c"),
                Set.of("d", "e"),
                Set.of("c", "e", "f"),
                Set.of("x", "y")
        );

        Set<String> targetSet =Set.of("c","z");
        System.out.println("Target Set: "+targetSet);

        System.out.println("\n Set that intersect with target: ");

        for(Set<String> set:allSets){
            Set<String> intersection = new HashSet<>(set);
            intersection.retainAll(targetSet);


            if(!intersection.isEmpty()){
                System.out.println(set+" intersects target "+intersection);
            }
        }

    }
}
