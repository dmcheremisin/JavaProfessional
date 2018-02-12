package $04FunctionalInterfaces.collectors;

import $04FunctionalInterfaces.streams.Collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 12.02.2018.
 */
public class PartitioningBy {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("lions", "tigers", "bears");

        Map<Boolean, List<String>> groups = animals.stream().collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(groups); // {false=[tigers], true=[lions, bears]}

        Map<Boolean, Set<String>> groupSet = animals.stream()
                .collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.toSet()));
        System.out.println(groupSet); // {false=[tigers], true=[lions, bears]}

        Map<Boolean, Long> counting = animals.stream()
                .collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.counting()));
        System.out.println(counting); // {false=1, true=2}
    }
}
