package com.Collection_Exercises.Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerProductOrder {
    public static void main(String[] args) {

        List<String[]> orders = List.of(
                new String[]{"Rohit","Laptop"},
                new String[]{"Sumit","Pen"},
                new String[]{"Shubham","Car"},
                new String[]{"Rohit","Car"},
                new String[]{"Sumit","Laptop"},
                new String[]{"Rohit","Laptop"}
        );

        Map<String,Map<String,Integer>> custOrder =new HashMap<>();

        for(String[] order:orders){
            String customer = order[0];
            String product = order[1];

            custOrder.computeIfAbsent(customer,k->new HashMap<>())
                    .merge(product,1,Integer::sum);
        }
        custOrder.forEach((cust,prodMap)->
                System.out.println(cust+" : "+prodMap)
        );
    }
}
