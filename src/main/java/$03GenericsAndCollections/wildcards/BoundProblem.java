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
        printList(keywords);
        // printObjectList(keywords); doesn't compile

        List objects = new ArrayList();
        objects.add("java");
        printList(objects);
        printObjectList(objects);
    }
    private static void printList(List list) {
        list.forEach(System.out::println);
    }
    private static void printObjectList(List<Object> list) {
        list.forEach(System.out::println);
    }
}
