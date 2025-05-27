package com.Collection_Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Diff_Small_Large_Element {
    public static int diff_bet_M_L(List<Integer> list){
        int min = Collections.min(list);
        int max = Collections.max(list);
        int Diff = max-min;
        return Diff;
    }
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(8,3,1,4,9,7,6);
        int Diff = diff_bet_M_L(list);
        System.out.println("Difference bet Largest and Smallest element: "+Diff);
    }
}
