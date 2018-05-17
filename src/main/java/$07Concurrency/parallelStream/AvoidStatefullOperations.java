package $07Concurrency.parallelStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class AvoidStatefullOperations {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("kangaroo", "jackal", "lemur");
        animals.parallelStream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);
        //jackal
        //kangaroo
        //lemur
        //KANGAROO
        //JACKAL
        //LEMUR

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Consumer consumer = i -> System.out.print(i + " ");
        List<Object> data = Collections.synchronizedList(new ArrayList<>());
        numbers.parallelStream()
                .map(i -> {
                    data.add(i);
                    return i;
                })
                .forEachOrdered(consumer); // 1 2 3 4 5 6
        System.out.println();
        data.forEach(consumer); // 6 4 5 1 3 2
        System.out.println();

        System.out.println(numbers.stream().findAny().get()); // always 1
        System.out.println(numbers.parallelStream().findAny().get()); // diferent numbers: 4, 1, ...
    }
}
