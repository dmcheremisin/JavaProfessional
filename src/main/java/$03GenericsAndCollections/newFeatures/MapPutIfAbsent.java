package $03GenericsAndCollections.newFeatures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitrii on 30.01.2018.
 */
public class MapPutIfAbsent {
    public static void main(String[] args) {
        Map<String, String> trips = new HashMap<>();
        System.out.println(trips.put("Jenny", "Bus Tour")); // null
        System.out.println(trips.put("Jenny", "Tram")); // Bus Tour
        System.out.println(trips); // {Jenny=Tram}

        trips.put("Tom", null);
        System.out.println(trips); // {Tom=null, Jenny=Tram}

        // putIfAbsent
        System.out.println(trips.putIfAbsent("Tom", "Ship")); // null
        System.out.println(trips.putIfAbsent("Jenny", "Train")); // Tram
        System.out.println(trips); // {Tom=Ship, Jenny=Tram}
    }
}
