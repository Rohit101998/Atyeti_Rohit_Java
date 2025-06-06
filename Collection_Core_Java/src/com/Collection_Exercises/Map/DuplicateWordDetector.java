package com.Collection_Exercises.Map;

import java.util.*;

public class DuplicateWordDetector {
    public static void main(String[] args) {

        Map<String, List<String>> files = Map.of(
                "file1.txt",List.of("Apple","Banana","Grapes"),
                "file2.txt",List.of("Rohit","Shubham","Apple"),
                "file3.txt",List.of("Banana","Orange","Grapes")
        );

        Map<String, Set<String>> textFile = new HashMap<>();

        for(Map.Entry<String,List<String>> file:files.entrySet()){
            String filename =file.getKey();
            for(String word: file.getValue()){
                textFile.computeIfAbsent(word,k->new HashSet<>()).add(filename);
            }
        }
        System.out.println(textFile);

        System.out.println("Words in multiple file: ");
        textFile.forEach((word,fileSet)->{
            if(fileSet.size() > 1){
                System.out.println(word+" : "+fileSet);
            }
        });

    }
}
