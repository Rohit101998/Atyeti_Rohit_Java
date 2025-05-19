package com.String;

import java.util.Scanner;

public class String_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String a = sc.next();
        String ch = "";
        for(int i=a.length()-1;i>=0;i--){
            ch = ch+a.charAt(i);
        }
        if(a.equals(ch)){
            System.out.println("The given String is Palindrome");
        }else{
            System.out.println("The given String is not Palindrome");
        }
    }
}
