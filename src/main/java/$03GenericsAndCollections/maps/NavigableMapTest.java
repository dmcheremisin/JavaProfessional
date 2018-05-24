package $03GenericsAndCollections.maps;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Dmitrii on 24.05.2018.
 */
public class NavigableMapTest {
    public static void main(String[] args) {
        NavigableMap<String, String> mymap = new TreeMap<String, String>();
        mymap.put("a", "apple");
        mymap.put("b", "boy");
        mymap.put("c", "cat");
        mymap.put("aa", "apple1");
        mymap.put("bb", "boy1");
        mymap.put("cc", "cat1");

        mymap.pollLastEntry();
        System.out.println("mymap pollLastEntry: " + mymap); // {a=apple, aa=apple1, b=boy, bb=boy1, c=cat}

        mymap.pollFirstEntry();
        System.out.println("mymap pollFirstEntry: " + mymap); // {aa=apple1, b=boy, bb=boy1, c=cat}

        NavigableMap<String, String> tailmap = mymap.tailMap("bb", false);// inclusive = false(otherwise "bb" key will be included)
        // tailMap is bonded with original mymap.
        // if something is deleted in tailMap - it will reflect the same deletion in the mymap, and vice versa
        System.out.println("tailmap tailMap: " + tailmap); // {c=cat}
        System.out.println("mymap tailMap: " + mymap); // {aa=apple1, b=boy, bb=boy1, c=cat}

        System.out.println("tailmap pollFirstEntry: " + tailmap.pollLastEntry()); // c=cat
        System.out.println("tailmap pollFirstEntry: " + tailmap); // {}
        System.out.println("mymap pollFirstEntry: " + mymap); // {aa=apple1, b=boy, bb=boy1}

        System.out.println(mymap.size()); // 3
    }
}
