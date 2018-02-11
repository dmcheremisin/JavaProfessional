package $04FunctionalInterfaces.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 11.02.2018.
 */
public class CollectingToMap {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("lions", "tigers", "bears");

        // 1. toMap(Function k, Function v)
        Map<String, Integer> map = animals.stream()
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map); // {lions=5, bears=5, tigers=6}

        // Wrong - because we have two duplicate lenghts == 5
        // Map<Integer, String> map1 = animals.stream()
        //        .collect(Collectors.toMap(String::length, k -> k));
        //Exception in thread "main" java.lang.IllegalStateException: Duplicate key lions

        // 2. toMap(Function k, Function v, BinaryOperator m)
        Map<Integer, String> map1 = animals.stream().collect(
                Collectors.toMap(String::length, k -> k,  (s1, s2) -> s1 + "," + s2));
        System.out.println(map1); // {5=lions,bears, 6=tigers}

        // 3. toMap(Function k, Function v, BinaryOperator m, Supplier s)
        TreeMap<Integer, String> map3 = animals.stream().collect(
                Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2,
                        TreeMap::new));
        System.out.println(map3); // {5=lions,bears, 6=tigers}
    }
}
