package com.Collection_Exercises.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OrderQueueSystem {
    public static void main(String[] args) {
        OrderQueueSystem system = new OrderQueueSystem();
        system.placeOrder(101,"Book");
        system.placeOrder(102,"Laptop");
        system.placeOrder(103,"Pen");

        System.out.println(system.fulfillNextGlobalOrder());
        System.out.println(system.fulfillNextCustomerOrder(102));
        System.out.println(system.fulfillNextGlobalOrder());
        System.out.println(system.fulfillNextGlobalOrder());
    }

    private final Map<Integer, Queue<String>> customerOrder = new HashMap<>();
    private final Queue<Integer> globalOrder = new LinkedList<>();

    public void placeOrder(int customerId,String order){
        customerOrder.putIfAbsent(customerId,new LinkedList<>());
        customerOrder.get(customerId).offer(order);
        globalOrder.offer(customerId);
    }
    public String fulfillNextCustomerOrder(int customerId){
        Queue<String> orders = customerOrder.get(customerId);
        return (orders != null && !orders.isEmpty())?orders.poll():null;
    }
    public String fulfillNextGlobalOrder(){
        while (!globalOrder.isEmpty()){
            int customerId = globalOrder.poll();
            Queue<String> order =customerOrder.get(customerId);
            if(order != null && !order.isEmpty()){
                return order.poll();
            }
        }
        return "No global orders left";
    }



}
