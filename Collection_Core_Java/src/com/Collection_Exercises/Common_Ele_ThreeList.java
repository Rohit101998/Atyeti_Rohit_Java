package com.Collection_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Common_Ele_ThreeList {
    public static List<Integer> commonEle(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 =Arrays.asList(2,3,4);
        List<Integer> list3 = Arrays.asList(3,4,5);
        list1.retainAll(list2);
        list1.retainAll(list3);
        return list1;

    }

    public static void main(String[] args) {

        System.out.println(commonEle());
    }
}
