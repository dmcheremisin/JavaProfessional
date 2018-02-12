package $04FunctionalInterfaces.collectors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 12.02.2018.
 */
public class GroupingBy {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("lions", "tigers", "bears");
        Map<Integer, List<String>> base = animals.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(base);
        // {5=[lions, bears], 6=[tigers]}

        Map<Integer, Set<String>> set = animals.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(set);
        // {5=[lions, bears], 6=[tigers]}

        TreeMap<Integer, Set<String>> tree = animals.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(tree);
        // {5=[lions, bears], 6=[tigers]}
    }
}
