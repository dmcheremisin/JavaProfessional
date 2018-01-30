package $03GenericsAndCollections.newFeatures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Created by Dmitrii on 30.01.2018.
 */
public class MapMerge {
    public static void main(String[] args) {
        BiFunction<String, String, String> mapper =
                (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> trip = new HashMap<>();
        trip.put("Jenny", "Bus tour");
        trip.put("Tom", "Tram");

        String merge1 = trip.merge("Jenny", "Skyride", mapper);// Bus tour > Skyride -> Bus tour
        System.out.println(merge1); // Bus tour
        String merge2 = trip.merge("Tom", "Skyride", mapper);// Tram < Skyride -> Skyride
        System.out.println(merge2); // Skyride
        System.out.println(trip);
        // {Tom=Skyride, Jenny=Bus tour}

        // case with null value
        trip.put("Sam", null);
        String merge3 = trip.merge("Sam", "Train", mapper);// mapper function is not clled
        System.out.println(merge3); // Train
        System.out.println(trip);
        // {Tom=Skyride, Jenny=Bus tour, Sam=Train}

        // case mapper returns null value
        BiFunction<String, String, String> nullMapper = (v1, v2) -> null;
        String sam = trip.merge("Sam", "Tuktuk", nullMapper);
        System.out.println(sam); // null
        System.out.println(trip);
        // {Tom=Skyride, Jenny=Bus tour}
        trip.merge("Jill", "Car", nullMapper); // mapper is not called
        System.out.println(trip);
        //{Tom=Skyride, Jill=Car, Jenny=Bus tour}

    }
}
