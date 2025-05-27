package com.Collection_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rotate_List_K_Position {
    public static List<Integer> rotateLeft(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int k=1;
        Collections.rotate(list,-k);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(rotateLeft());
    }
}
