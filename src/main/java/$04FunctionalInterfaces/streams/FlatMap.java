package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class FlatMap {
    public static void main(String[] args) {
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Gorilla", "Ape");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(l -> l.stream()).forEach(System.out::println);
        // Bonobo
        // Gorilla
        // Ape

    }
}
