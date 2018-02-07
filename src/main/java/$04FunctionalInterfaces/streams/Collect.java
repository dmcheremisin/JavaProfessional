package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class Collect {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("w", "o", "l", "f");

        StringBuilder wolf1 = list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(wolf1); // wolf1

        TreeSet<String> flow1 = list.stream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(flow1); // [f, l, o, w]

        TreeSet<String> flow2 = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(flow2); // [f, l, o, w]

        Set<String> flow3 = list.stream().collect(Collectors.toSet());
        System.out.println(flow3); // [f, w, l, o]
        List<String> wolf2 = list.stream().collect(Collectors.toList());
        System.out.println(wolf2); // [w, o, l, f]


        String wolf3 = list.stream().collect(String::new, String::concat, String::concat);
        System.out.println("3" + wolf3); // 3
    }
}
