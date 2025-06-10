package com.Collection_Exercises.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetRemover {
    public static void main(String[] args) {
        Set<Set<String>> input = new HashSet<>(Set.of(
                Set.of("a", "b"),
                Set.of("a", "b", "c"),
                Set.of("x", "y"),
                Set.of("x", "y", "z")
        ));

        List<Set<String>> sets = new ArrayList<>(input);
        Set<Set<String>> redundant = new HashSet<>();

        for(int i=0;i< sets.size();i++){
            for (int j=0;j< sets.size();j++){
                if(i!=j && sets.get(j).containsAll(sets.get(i))){
                    redundant.add(sets.get(i));
                }

            }
        }

        input.removeAll(redundant);

        System.out.println("\n Filtered sets after removing subset: ");
        for(Set<String> st:input){
            System.out.println(st);
        }
    }
}
