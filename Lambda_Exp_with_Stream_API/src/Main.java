import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
       // Java 8
        // minimal code , functional programmingI

        Thread t1  = new Thread(() ->{
            System.out.println("Hello");
        });

        MathOperation sumOperation = (a,b) -> a + b;
        MathOperation subtractOperation = (a,b) ->a - b;
        int res = sumOperation.operate(1,2);
        System.out.println(res);

        //Predicate --> Functional interface (Boolean valued function)

         Predicate<Integer> isEven = x->x % 2 == 0;
        System.out.println(isEven.test(4));
        Predicate<String> isWordStartWithA = x->x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndWithT = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and  =isWordStartWithA.and(isWordEndWithT);
        System.out.println(and.test("Akshay"));
         
     // Function -->
        Function<Integer,Integer> doubleIt = x->2 * x;
        Function<Integer,Integer> tripleIt = x->3 * x;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(20));
        System.out.println(doubleIt.apply(100));
        Function<Integer,Integer> identity = Function.identity();
        Integer res2 =identity.apply(5);
        System.out.println(res2);


        //Consumer(can't return any value)

        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(51);
        List<Integer> list = Arrays.asList(1,2,3);
        Consumer<List<Integer>> printList = x->{
            for(int i : x){
                System.out.println(i);
            }
        };
        printList.accept(list);


        //supplier(It cant take anything but return value, supplier having only one method get())

        Supplier<String> giveValue = () -> "Hello World";
        System.out.println(giveValue.get());

        //Combined Example
        Predicate<Integer> predicate = x-> x % 2 == 0;
        Function<Integer,Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }


    }

}
interface MathOperation{
    int operate(int a,int b);
}