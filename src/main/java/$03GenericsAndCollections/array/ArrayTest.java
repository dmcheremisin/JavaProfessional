package $03GenericsAndCollections.array;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 9, 8};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 6, 8, 9]

        System.out.println(Arrays.binarySearch(numbers, 6)); // 1
        System.out.println(Arrays.binarySearch(numbers, 2)); // -2

        // results are unpredictable
        int[] newNumbers = {3, 1, 9, 5};
        System.out.println(Arrays.binarySearch(newNumbers, 5)); // -3
        System.out.println(Arrays.binarySearch(newNumbers, 2)); // -3

    }
}
