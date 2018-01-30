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

        System.out.println(counts.computeIfPresent("Jenny", function));// 2
        System.out.println(counts.computeIfPresent("Tom", function));// null
        System.out.println(counts.computeIfPresent("Sam", function));// null
        System.out.println(counts);
        // {Tom=null, Jenny=2}

        Map<String, Integer> other = new HashMap<>();
        other.put("Jenny", 1);
        other.put("Tom", null);

        BiFunction<String, Integer, Integer> nullFunc = (k, v) -> null;

        System.out.println(other.computeIfPresent("Jenny", nullFunc));// null
        System.out.println(other.computeIfPresent("Tom", nullFunc));// null
        System.out.println(other.computeIfPresent("Sam", nullFunc));// null
        System.out.println(other);
        // {Tom=null}
    }
}
