package com.String;

import java.util.Scanner;

public class String_Devide_Print {
    public static void main(String[] args) {
        String email ="rohit.patil@gmail.com";
        Scanner sc = new Scanner(System.in);
        if(email.length()>=3){

            System.out.println("Enter length of 1st String: ");
            int a = sc.nextInt();

            System.out.println("Enter length of 2nd String: ");
            int b=sc.nextInt();

            int c= email.length()-a-b;

            String pr1 = email.substring(0,a);
            String pr2 = email.substring(a,a+b);
            String pr3 = email.substring(a+b);

            System.out.println("\n"+pr1);
            System.out.println("\n"+pr2);
            System.out.println("\n"+pr3);
        }else {
            System.out.println("Email length is too short");
        }
    }
}
