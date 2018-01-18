package $03GenericsAndCollections.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 18.01.2018.
 */
public class BoundProblem {
    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        // printObjectList(keywords); doesn't compile
        printList(keywords);
        printListWidcard(keywords); // compiles OK

        List objects = new ArrayList();
        // OR
        // List<Object> objects = new ArrayList<>();
        // doesn't make sense - compiles and works Ok
        objects.add("java");
        printList(objects);
        printObjectList(objects);
        printListWidcard(objects); // compiles OK
    }
    private static void printObjectList(List<Object> list) {
        list.forEach(System.out::println);
    }
    private static void printList(List list) {
        list.forEach(System.out::println);
    }
    // accepts list with any type
    private static void printListWidcard(List<?> list) {
        list.forEach(System.out::println);
    }
}
