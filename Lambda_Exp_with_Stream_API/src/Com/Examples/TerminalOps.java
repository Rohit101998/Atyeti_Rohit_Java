package Com.Examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(1,2,3);

        //collect
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

        //forEach
        list.stream().forEach(x-> System.out.println(x));

        //reduce
        //Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y);

        //or

        Optional<Integer> optionalInteger1 = list.stream().reduce(Integer::sum);

        System.out.println(optionalInteger1);

        //anyMatch ,allMatch, noneMatch
        boolean match = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(match);

        boolean match1 = list.stream().allMatch(x -> x > 0);
        System.out.println(match1);

        boolean match2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(match2);


        //findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // toArray()
        Object[] array = Stream.of(1,2,3).toArray();

        // Min / Max
        System.out.println("Max: "+ Stream.of(2,44,69).max((o1, o2) -> o2-o1));
        System.out.println("Min: "+ Stream.of(2,44,66).min(Comparator.naturalOrder()));

        //forEachOrdered
        List<Integer> numbers0 =Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Using forEach with parallel stream: ");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream: ");
        numbers0.parallelStream().forEachOrdered(System.out::println);



        // Filtering and collecting names
        List<String> names =Arrays.asList("Rohit","Vishal","swapnil","Sumit");
        System.out.println(names.stream().filter(x->x.length() > 3).toList());

        // Squaring and sorting numbers
        List<Integer> numbers = Arrays.asList(5,2,9,1,6);
        System.out.println(numbers.stream().map(x->x * x).sorted().toList());

        // Summing Values
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        System.out.println(integers.stream().reduce(Integer::sum).get());


        // Counting Occurrences of Character
        String sentence = "Hello world";
        System.out.println(sentence.chars().filter(x->x == 'l').count());

        // stream can not be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
        //List<String> list1 = stream.map(String::toUpperCase).toList();  //exception



    }
}
