package com.Collection_Exercises.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NestedQueueExample {
    public static void main(String[] args) {
        Queue<String> gate1 = new LinkedList<>();
        gate1.add("Rohit");
        gate1.add("Shubham");

        Queue<String> gate2 = new LinkedList<>();
        gate2.add("Sumit");
        gate2.add("Vishal");

        Queue<String> gate3 = new LinkedList<>();
        gate3.add("Sejal");

        Queue<Queue<String>> queue = new LinkedList<>();
        queue.add(gate1);
        queue.add(gate2);
        queue.add(gate3);

        System.out.println("Boarding Passenger: ");

        while (!queue.isEmpty()){
            Queue<String> getQueue = queue.poll();

        while (!getQueue.isEmpty()){
            System.out.println(getQueue.poll());
        }
        }
    }
}
