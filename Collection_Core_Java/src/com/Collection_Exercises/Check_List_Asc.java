package com.Collection_Exercises;

import java.util.Arrays;
import java.util.List;

public class Check_List_Asc{

    public static boolean isSorted(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(isSorted());
    }
}
