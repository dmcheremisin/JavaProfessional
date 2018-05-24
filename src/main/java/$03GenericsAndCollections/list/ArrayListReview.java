package $03GenericsAndCollections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListReview {
    public static void main(String[] args) {
        arrayVsArrayList();
        binarySearchTest();
        autoboxing();
    }

    private static void autoboxing() {
        List<Integer> list = new ArrayList<Integer>(){{
            add(1); add(2); add(new Integer(3)); add(4);
        }};
        list.remove(1);
        System.out.println(list);// [1, 3, 4]
    }

    private static void binarySearchTest() {
        List<Integer> list = Arrays.asList(9, 5, 7, 3);
        Collections.sort(list);
        System.out.println(list);// [3, 5, 7, 9]
        System.out.println(Collections.binarySearch(list, 5)); // 1
        System.out.println(Collections.binarySearch(list, 6)); // -3
    }

    private static void arrayVsArrayList() {
        String[] array = {"one", "two", "three"};
        System.out.println(Arrays.toString(array));// [one, two, three]


        List<String> list = Arrays.asList(array);
        System.out.println(list);// [one, two, three]

        // list is created from array and can't change size
        // list.add("four"); throws java.lang.UnsupportedOperationException
        // list.remove(1); throws java.lang.UnsupportedOperationException

        array[0] = "four";
        System.out.println(list); // [four, two, three]

        list.set(2, "five");
        System.out.println(Arrays.toString(array));// [four, two, five]
    }
}
