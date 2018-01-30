package $03GenericsAndCollections.newFeatures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Dmitrii on 30.01.2018.
 */
public class MapComputeIfAbsent {
    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        counts.put("Tom", null);

        Function<String, Integer> function = (k) -> 2;

        System.out.println(counts.computeIfAbsent("Jenny", function));//1
        System.out.println(counts.computeIfAbsent("Tom", function));//2
        System.out.println(counts.computeIfAbsent("Sam", function));//2
        System.out.println(counts);
        // {Tom=2, Jenny=1, Sam=2}

        Map<String, Integer> other = new HashMap<>();
        other.put("Jenny", 1);
        other.put("Tom", null);

        Function<String, Integer> nullFunc = (k) -> null;

        System.out.println(other.computeIfAbsent("Jenny", nullFunc)); // 1
        System.out.println(other.computeIfAbsent("Tom", nullFunc));// null
        System.out.println(other.computeIfAbsent("Sam", nullFunc));// null
        System.out.println(other);
        // {Tom=null, Jenny=1}
    }
}
