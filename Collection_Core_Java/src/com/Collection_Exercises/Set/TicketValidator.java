package com.Collection_Exercises.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TicketValidator {
    public static void main(String[] args) {
        List<Integer> ticket = Arrays.asList(5, 12, 23, 34, 45);

        Set<Integer> uniqueNumbers = new HashSet<>(ticket);
        if (uniqueNumbers.size() != ticket.size()) {
            System.out.println("Invalid ticket.");
        } else {
            System.out.println("Valid ticket!");
        }
    }
}
