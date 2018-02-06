package $04FunctionalInterfaces.streams;

import java.util.stream.Stream;

/**
 * Created by Dmitrii on 06.02.2018.
 */
public class FindAnyFindFirst {
    public static void main(String[] args) {
        Stream<String> finite = Stream.of("gorilla", "monkey", "ape");
        finite.findAny().ifPresent(System.out::println); // gorilla

        Stream<String> infinite = Stream.generate(() -> "chimp");
        infinite.findAny().ifPresent(System.out::println); // chimp

        Stream<String> parallelAny = Stream.of("gorilla", "monkey", "ape").parallel();
        Stream<String> parallelFirst = Stream.of("gorilla", "monkey", "ape").parallel();
        parallelAny.findAny().ifPresent(System.out::println); // monkey
        parallelFirst.findFirst().ifPresent(System.out::println); // gorilla

    }
}
