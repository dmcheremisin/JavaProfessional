package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class Filter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("gorilla", "monkey", "ape");
        List<String> filtered = list.stream().filter(s -> s.startsWith("m")).collect(Collectors.toList());
        System.out.println(filtered);
        // [monkey]
        list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println); // ape
    }
}
