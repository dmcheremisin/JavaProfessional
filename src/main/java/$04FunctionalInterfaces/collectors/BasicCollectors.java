package $04FunctionalInterfaces.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 11.02.2018.
 */
public class BasicCollectors {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("lions", "tigers", "bears");

        String str = animals.stream().collect(Collectors.joining(", "));
        System.out.println(str); // lions, tigers, bears

        Double result = animals.stream().collect(Collectors.averagingInt(String::length));
        System.out.println(result); // 5.333333333333333

        TreeSet<String> t = animals.stream().filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(t); // [tigers]
    }
}
