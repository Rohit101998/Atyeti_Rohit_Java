package com.Collection_Exercises;

import java.util.Arrays;

public class Identical_Array {
    public static boolean identical(){
        int[] arr1 ={1,2,3};
        int[] arr2 = {1,2,3};
        return Arrays.equals(arr1,arr2);
    }
    public static void main(String[] args) {

        System.out.println(identical());
    }
}
