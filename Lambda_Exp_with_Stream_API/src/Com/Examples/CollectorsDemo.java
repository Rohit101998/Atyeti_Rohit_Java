package Com.Examples;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {

        //Collecting to list
        List<String> names = Arrays.asList("Rohit","Shubham","Sumit");
        List<String> res = names.stream().filter(name -> name.startsWith("R"))
                .collect(Collectors.toList());
        System.out.println(res);

        //Collecting to set

        List<Integer> nums = Arrays.asList(1,2,2,3,4,4,5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);

        //Collecting a specific collection
        names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println(names);

        //Joining Strings
        //concatenate stream element into a single String
        String concatinatedName = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatinatedName);

        //Summarizing Data
        //Generate Statistical summary(count, sum, min, Avg, max)

        List<Integer> numbers = Arrays.asList(2,3,5,7,8,11);
        IntSummaryStatistics start = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: "+start.getCount());
        System.out.println("Sum: "+start.getSum());
        System.out.println("Min: "+start.getMin());
        System.out.println("Max: "+start.getMax());
        System.out.println("Average: "+start.getAverage());

        //Calculating Average
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println(average);

        //counting Element
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println(count);

        //grouping Element
        List<String> word = Arrays.asList("collection","hello","world","java","stream");
        System.out.println(word.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(word.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(", "))));
        System.out.println(word.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
        TreeMap<Integer, Long> treeMap = word.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

        //Partitioning Element
        //partitioning element into two groups(True and false) based on predicates

        System.out.println(word.stream().collect(Collectors.partitioningBy(x->x.length()>5)));

        //Mapping and Collecting
        //Apply Mapping function before collecting
        System.out.println(word.stream().collect(Collectors.mapping(String::toUpperCase,Collectors.toList())));

        //Collecting name by length
        List<String> l1 =Arrays.asList("Ram","Shubham","Alice", "Muskan","Sumit","Swapnil");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        //counting and word occurrences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        //Partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2==0)));

       //Summing value in a map
        Map<String,Integer> items = new HashMap<>();
        items.put("Apple",10);
        items.put("Banana",20);
        items.put("Orange",15);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summingInt(x->x)));


        //creating a map from stream elements
        List<String> fruits = Arrays.asList("Apple","Banana","Orange","Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase,String::length)));


        // creating a map from stream element and find particular count of that String
        List<String> words2 = Arrays.asList("apple","banana","apple","orange","banana","apple");
        System.out.println(words2.stream().collect(Collectors.toMap(k->k,v->1,(x,y)->x+y)));


    }
}
