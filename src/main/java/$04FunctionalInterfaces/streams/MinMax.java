package $04FunctionalInterfaces.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 06.02.2018.
 */
public class MinMax {
    public static void main(String[] args) {
        Comparator<String> c = (s1, s2) -> s1.length() - s2.length();

        Stream<String> str1 = Stream.of("gorilla", "monkey", "ape");
        Optional<String> min = str1.min(c);
        min.ifPresent(System.out::println); // ape

        Stream<String> str2 = Stream.of("gorilla", "monkey", "ape");
        str2.max(c).ifPresent(System.out::println); // gorilla

        System.out.println(Stream.empty().min((s1, s2) -> 0)); // Optional.empty
    }
}
