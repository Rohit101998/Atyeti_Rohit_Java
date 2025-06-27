package Com.Executor.Order_Processing_System;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OrderProcessor {
    static Map<String,Integer> stock = new HashMap<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        stock.put("Laptop",5);
        stock.put("Mobile",10);

        List<Order> orders = Arrays.asList(
                new Order(1,"Rohit","Laptop",1),
                new Order(2,"Shubham","Mobile",3),
                new Order(3,"Pranav","Laptop",2),
                new Order(4,"Shubham","Mobile",5),
                new Order(5,"Lokesh","Mobile",8),
                new Order(6,"Sumit","Laptop",7)

        );

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<OrderResult>> futures = new ArrayList<>();

        for(Order order:orders){
            futures.add(executor.submit(()->processerOrder(order)));
        }


        for (Future<OrderResult> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
     }
     public static OrderResult processerOrder(Order order){
        synchronized (stock){
            Integer available = stock.get(order.product);
            if(available == null || available < order.quantity){
                return new OrderResult(order.orderId,"Failed out of stock");
            }else {
                stock.put(order.product,available-order.quantity);
                return new OrderResult(order.orderId,"Success: Order confirmed");
            }
        }
     }
}
