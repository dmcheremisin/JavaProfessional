package $07Concurrency.parallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("w", "o", "l", "f");

        ConcurrentSkipListSet<Object> skipListSet = list.parallelStream()
                .collect(ConcurrentSkipListSet::new,
                        Set::add,
                        Set::addAll);
        System.out.println(skipListSet); // [f, l, o, w] - ordered set

        Set<String> set = list.parallelStream().collect(Collectors.toSet());
        System.out.println(set); // [f, w, l, o] - not ordered set

        List<String> animals = Arrays.asList("lions", "tigers", "bears");

        ConcurrentMap<Integer, String> concurrentMap = animals.parallelStream()
                .collect(
                        Collectors.toConcurrentMap(
                                v -> v.length(),
                                k -> k,
                                (s1, s2) -> s1 + ", " + s2)
                );
        System.out.println(concurrentMap); // {5=bears, lions, 6=tigers}

        ConcurrentMap<Integer, List<String>> map = animals.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map);// {5=[bears, lions], 6=[tigers]}
    }
}
