package com.Collection_Exercises.Set;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PasswordHistory {
    public static void main(String[] args) {
        List<String> list = List.of("abc@123", "pass@321", "pqr#456");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new Password: ");
        String newPassword = sc.nextLine();

        Set<String> set = new HashSet<>(list);

        if(set.contains(newPassword)){
            System.out.println("Can not reuse old Password");
        }else{
            System.out.println("Password Accepted");
        }



    }
}
