package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 06.02.2018.
 */
public class Reduce {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("w", "o", "l", "f");
        String wolf = list.stream().reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(wolf); // wolf

        String wolf2 = list.stream().reduce("", String::concat);
        System.out.println(wolf2); // wolf

        List<Integer> integers = Arrays.asList(3, 5, 6);
        BinaryOperator<Integer> mult = (a, b) -> a * b;

        Integer reduce = integers.stream().reduce(1, mult);
        System.out.println(reduce); // 90

        // reduce with one parameter mult
        Optional<Integer> reduce2 = integers.stream().reduce(mult);
        reduce2.ifPresent(System.out::println); // 90

        // empty and 1 element
        Stream.empty().reduce((a, b) -> 1+1).ifPresent(System.out::println); // no output
        Stream.of(1).reduce(mult).ifPresent(System.out::println); // 1

        // reduce with 3 arguments is usefull for parallel stream
        System.out.println(integers.stream().parallel().reduce(1, mult, mult)); // 90
    }
}
