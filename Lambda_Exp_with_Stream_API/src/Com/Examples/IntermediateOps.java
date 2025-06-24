package Com.Examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {

        //filter
        List<String> list = Arrays.asList("Rohit","Ram","Raj");
        long count = list.stream().filter(x -> x.startsWith("R")).count();

        System.out.println(count);

        //Map
        Stream<String> stringstream = list.stream().map(String::toUpperCase);
        System.out.println(stringstream);

        //sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sortedStringUsingComparetor = list.stream().sorted((a, b) -> a.length() - b.length());

        //Distinct
        System.out.println(list.stream().filter(x->x.startsWith("R")).distinct().count());

        //Limit
        System.out.println(Stream.iterate(1,x->x+1).limit(100).count());

        //skip
        System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(100).count());

        //peek
        //Perform an action on each element as it is consumed
        Stream.iterate(1,x->x+1).skip(10).limit(100).peek(System.out::println).count();

        //flatMap
        //Handel Stream of collections, lists or arrays where each element is itself a collection
        List<List<String>> listofLists = Arrays.asList(
               Arrays.asList("Apple","banana"),
               Arrays.asList("Orange","Kiwi"),
               Arrays.asList("pear","grape")
        );

        System.out.println(listofLists.get(1).get(1));
        System.out.println(listofLists.stream().flatMap(x->x.stream()).map(String::toUpperCase).toList());

        List<String> sentences = Arrays.asList(
                "Hello world",
                "java stream are powerful",
                "flatmap is useful"
        );

        System.out.println(sentences.stream()
                .flatMap(sentence->Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase).toList());
    }

}
