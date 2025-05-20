package com.collection_Product_Inventory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class InventoryApp {
    public static void main(String[] args) {
        //1. Add product to a Map(product ID -> product)
        Map<Integer, Product> map = new HashMap<>();

        map.put(101,new Product(101,"Laptop",60000,20));
        map.put(102, new Product(102,"Car",900000,30));
        map.put(103,new Product(103,"Mobile",400000,10));
        map.put(104,new Product(104,"Monitor",10000,20));

        // 2. Display all Product

        map.values().forEach(System.out::println);

        System.out.println("=====================================================================");

        //3. Filter Product by Price range

        map.values().stream().filter(pr->pr.getPrice()>=10000 && pr.getPrice()<=60000).forEach(System.out::println);

        System.out.println("==========================================================");

        //4. sort Product by stock quantity (desc)

       map.values().stream().sorted(Comparator.comparingDouble(Product::getQuantity).reversed()).forEach(System.out::println);

        System.out.println("==============================================================");

       //5. Find Product out of stock

        map.values().stream().filter(pr->pr.getQuantity()==0).forEach(System.out::println);

        System.out.println("===========================================================");

        //6. Calculate total stock value (Price * quantity)

        double sum = map.values().stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
        System.out.println("\n Total stock value is: "+sum);
    }
}
