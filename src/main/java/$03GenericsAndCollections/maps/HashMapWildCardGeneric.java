package $03GenericsAndCollections.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Dmitrii on 24.05.2018.
 */

class MyList<E> extends ArrayList<E>{}

public class HashMapWildCardGeneric {
    public static void main(String[] args) {
        //Map map1 = new TreeMap();                                  -> java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        // Map<Object, Object> map1 = new TreeMap<Object, Object>(); -> java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        //String, Integer, and Double are not mutually comparable.

        Map map1 = new HashMap<>();
        map1.put("1", new ArrayList<>());
        map1.put(1, new Object());
        map1.put(1.0, "Hello");
        System.out.println(map1);
        // {1=[], 1=java.lang.Object@45ee12a7, 1.0=Hello}

        Map<Object, ? super ArrayList> map2 = new LinkedHashMap<Object, ArrayList>();
        map2.put("1", new ArrayList<>()); // OK
        map2.put(1.0, new MyList<>()); // OK
        // map2.put(1, new Object()); -> ArrayList required
        // map2.put(1.0, "Hello"); -> ArrayList required
        System.out.println(map2);
        // {1=[], 1.0=[]}

    }
}
