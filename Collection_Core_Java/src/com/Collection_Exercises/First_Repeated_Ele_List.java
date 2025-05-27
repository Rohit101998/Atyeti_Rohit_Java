package com.Collection_Exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class First_Repeated_Ele_List {
    public static int repeatedEle(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        for(Integer in:list){
            if (set.contains(in)){
                return in;
            }
            set.add(in);

        }
        return -1;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,2,4,1,1);
        System.out.println(repeatedEle(list));
    }
}
