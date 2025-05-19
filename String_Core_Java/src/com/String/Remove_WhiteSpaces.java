package com.String;

public class Remove_WhiteSpaces {
    public static void main(String[] args) {
        String a = "I am Rohit Patil";
        String b= a.replaceAll("\\s","");
        System.out.println(b);
    }
}
