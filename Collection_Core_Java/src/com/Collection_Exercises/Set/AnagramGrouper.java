package com.Collection_Exercises.Set;

import java.util.*;

public class AnagramGrouper {
    public static void main(String[] args) {
        List<String> words = List.of("listen", "silent", "enlist", "rat", "tar", "art", "top", "pot", "opt");

     Map<String,Set<String>> anagramGroup = new HashMap<>();

     for(String word:words){
         char chars[]  = word.toCharArray();
         Arrays.sort(chars);
         String str = new String(chars);

         anagramGroup.computeIfAbsent(str,k->new HashSet<>()).add(word);
     }

     Set<Set<String>> groupAnagram = new HashSet<>(anagramGroup.values());

     System.out.println("Group Anagram");

     for(Set<String> group:groupAnagram){
         System.out.println(group);
     }

    }
}
