package $03GenericsAndCollections.newFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitrii on 29.01.2018.
 */
public class CollectionMethods {
    public static void main(String[] args) {
        // removeIf example
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Tiger");
        animals.removeIf(animal -> animal.startsWith("D"));
        System.out.println(animals);
        // [Cat, Tiger]

        // replaceAll example
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.replaceAll(i -> i*2);
        System.out.println(numbers);
        // [2, 4, 6]

        // foreach example
        animals.forEach(s -> System.out.println(s));
        animals.forEach(System.out::println);
        // Cat
        // Tiger
    }
}
