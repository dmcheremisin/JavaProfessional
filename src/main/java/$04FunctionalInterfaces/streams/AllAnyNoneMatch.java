package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 06.02.2018.
 */
public class AllAnyNoneMatch {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("gorilla", "monkey", "ape");
        Predicate<String> pred = s -> Character.isLetter(s.charAt(0));

        Stream<String> inf = Stream.generate(() -> "chimp");
        Stream<String> inf2 = Stream.generate(() -> "chimp");

        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // true
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(inf.anyMatch(pred)); // true
        // System.out.println(inf2.allMatch(pred)); search until application kill
    }
}
