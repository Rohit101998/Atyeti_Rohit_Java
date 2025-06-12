package com.Collection_Exercises.Queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DepartmentTicketSystem {
    public static void main(String[] args) {
        Queue<String> itQueue = new LinkedList<>(List.of("Reset Password","Install Software"));
        Queue<String> hrQueue = new LinkedList<>(List.of("New Hire Onboarding"));
        Queue<String> financeQueue = new LinkedList<>(List.of("Reimburse Travel","Approve Budget","Pay Vendor"));

        Queue<Queue<String>> departmentQueue = new LinkedList<>();
        departmentQueue.offer(itQueue);
        departmentQueue.offer(hrQueue);
        departmentQueue.offer(financeQueue);

        System.out.println("Ticket Processing Order: ");

        while (!departmentQueue.isEmpty()){
            Queue<String> stringQueue = departmentQueue.poll();

            if(!stringQueue.isEmpty()){
                System.out.println("=>"+stringQueue.poll());
            }
            if (!stringQueue.isEmpty()) {
                departmentQueue.offer(stringQueue);
            }
        }


    }
}
