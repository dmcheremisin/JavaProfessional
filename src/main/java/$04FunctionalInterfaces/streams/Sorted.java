package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class Sorted {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("tiger", "bear", "panda");
        animals.stream().sorted().forEach(System.out::println);
        // bear
        // panda
        // tiger

        animals.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // tiger
        // panda
        // bear

        // right order
        animals.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
        // OR
        animals.stream().sorted(String::compareTo).forEach(System.out::println);
        animals.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        // reverse order
        animals.stream().sorted((s1, s2) -> s2.compareTo(s1)).forEach(System.out::println);
        animals.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
