package com.String;

public class Leading_and_Trailing_Space {
    public static void main(String[] args) {
        String s = " abc def\t";
        s= s.strip();
        System.out.println(s);
    }
}
