package com.Collection_Exercises.Map;

import java.util.HashMap;
import java.util.Map;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, String> countryCap = Map.of(
                "India", "Delhi",
                "USA", "Washington",
                "Japan", "Tokyo"
        );

        Map<String, String> capCountry = new HashMap<>();
        for (Map.Entry<String, String> entry : countryCap.entrySet()) {
            capCountry.put(entry.getValue(), entry.getKey());
        }

        System.out.println(capCountry);
    }
}
