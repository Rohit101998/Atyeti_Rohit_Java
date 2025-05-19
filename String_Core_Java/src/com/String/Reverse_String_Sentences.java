package com.String;

public class Reverse_String_Sentences {
    public static void main(String[] args) {
        String a[] = "I am Rohit Patil".split(" ");
        String ch = "";

        for(int i=a.length-1; i>=0; i--){
           ch=ch+a[i]+" ";
        }
        System.out.println(ch);
    }
}
