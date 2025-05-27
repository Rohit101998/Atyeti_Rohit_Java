package com.Collection_Exercises;

import java.util.Arrays;

public class MaxProduct_Array {
    public static int maxProduct(){
        int [] arr ={1,2,3,4,5,6,7,8};
        Arrays.sort(arr);
        return arr[arr.length-1] * arr[arr.length-2];
    }

    public static void main(String[] args) {
        System.out.println(maxProduct());
    }
}
