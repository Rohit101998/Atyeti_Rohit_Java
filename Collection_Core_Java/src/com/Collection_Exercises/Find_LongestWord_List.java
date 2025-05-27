package com.Collection_Exercises;

import java.util.Arrays;
import java.util.List;

public class Find_LongestWord_List {
    public static String longestWord(List<String> list){
        String longest = "";
        for(String str:list){
            if(str.length()>longest.length()){
                longest=str;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Rohit","Swapnil","sumit","Shubham","Pratik");
        String str = longestWord(list);
        System.out.println("Longest word in List is: "+str);
    }
}
