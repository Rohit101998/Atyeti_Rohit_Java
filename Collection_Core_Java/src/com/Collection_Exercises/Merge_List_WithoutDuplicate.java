package com.Collection_Exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Merge_List_WithoutDuplicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        List<Integer> list1 = Arrays.asList(2,4,1);
        Set<Integer> set= new HashSet<>(list);
        set.addAll(list1);
        for(Integer in:set){
            System.out.println(in);
        }

    }
}
