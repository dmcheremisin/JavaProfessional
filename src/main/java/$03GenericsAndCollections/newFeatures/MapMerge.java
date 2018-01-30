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

        trip.merge("Jenny", "Skyride", mapper);// Bus tour > Skyride -> Bus tour
        trip.merge("Tom", "Skyride", mapper);// Tram < Skyride -> Skyride
        System.out.println(trip);
        // {Tom=Skyride, Jenny=Bus tour}

        // case with null value
        trip.put("Sam", null);
        trip.merge("Sam", "Train", mapper);// Train - mapper function is not clled
        System.out.println(trip);
        // {Tom=Skyride, Jenny=Bus tour, Sam=Train}

        // case mapper returns null value
        BiFunction<String, String, String> nullMapper = (v1, v2) -> null;

        trip.merge("Sam", "Tuktuk", nullMapper);// null
        System.out.println(trip);
        // {Tom=Skyride, Jenny=Bus tour}

        trip.merge("Jill", "Car", nullMapper); // mapper is not called
        System.out.println(trip);
        //{Tom=Skyride, Jill=Car, Jenny=Bus tour}

        trip.put("Mike", null);
        trip.merge("Mike", "Skate", nullMapper); // mapper is not called
        System.out.println(trip);
        // {Mike=Skate, Tom=Skyride, Jill=Car, Jenny=Bus tour}
    }
}
