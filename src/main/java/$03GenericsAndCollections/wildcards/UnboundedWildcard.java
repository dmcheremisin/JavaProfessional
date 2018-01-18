package $03GenericsAndCollections.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 18.01.2018.
 */
public class UnboundedWildcard {
    public static void main(String[] args) {
        // List<Number> list = new ArrayList<Integer>();
        // compilation problem - incompatible types

        // List<Object> list = new ArrayList<Integer>();
        // the same problem

        List<?> list = new ArrayList<Integer>(){{
            add(1); add(2); add(3);
        }};
        // compiles OK
        printList(list);
        // 1 2 3

        // addition doesn't compile due to type inference
        // list.add(new Integer(42)); doesn't work

        // this is a problem
        // I want to store only Integers, but I can assign a list to any type
        list = new ArrayList<String>(){{
            add("1"); add("2"); add("3");
        }};
        printList(list);
        // 1 2 3
    }

    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }
}
