package com.Collection_Exercises.Set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateBasketDetector {
    public static void main(String[] args) {
        List<Set<String>> baskets = List.of(
                Set.of("milk", "bread"),
                Set.of("bread", "milk"),
                Set.of("butter", "jam"),
                Set.of("jam", "butter"),
                Set.of("milk")
        );

        Set<Set<String>> uniqueBasket =new HashSet<>();
        Set<Set<String>> duplicateBasket = new HashSet<>();

        for(Set<String> basket:baskets){
            if(!uniqueBasket.add(basket)){
                duplicateBasket.add(basket);
            }
        }


        System.out.println("\nUnique Basket: ");
        for(Set<String> unique:uniqueBasket){
            System.out.println(unique);
        }

        System.out.println("\nDuplicate Basket: ");
        for(Set<String> duplicate:duplicateBasket){
            System.out.println(duplicate);
        }

        System.out.println("\nDuplicate basket Count: "+duplicateBasket.size());
        System.out.println("\nUnique basket Count: "+uniqueBasket.size());
    }
}
