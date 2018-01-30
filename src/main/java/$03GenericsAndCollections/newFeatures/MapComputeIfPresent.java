package $03GenericsAndCollections.newFeatures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Created by Dmitrii on 30.01.2018.
 */
public class MapComputeIfPresent {
    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        counts.put("Tom", null);

        BiFunction<String, Integer, Integer> function = (k, v) -> v+1;

        Integer jenny = counts.computeIfPresent("Jenny", function);
        System.out.println(jenny); // 2
        Integer tom = counts.computeIfPresent("Tom", function);
        System.out.println(tom); // null
        Integer sam = counts.computeIfPresent("Sam", function);
        System.out.println(sam); // null
        System.out.println(counts);
        // {Tom=null, Jenny=2}

        Map<String, Integer> other = new HashMap<>();
        other.put("Jenny", 1);
        other.put("Tom", null);

        BiFunction<String, Integer, Integer> nullFunc = (k, v) -> null;

        Integer jenny1 = other.computeIfPresent("Jenny", nullFunc);
        System.out.println(jenny1); // null
        Integer tom1 = other.computeIfPresent("Tom", nullFunc);
        System.out.println(tom1); // null
        Integer sam1 = other.computeIfPresent("Sam", nullFunc);
        System.out.println(sam1); // null
        System.out.println(other);
        // {Tom=null}
    }
}
