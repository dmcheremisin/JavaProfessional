package $03GenericsAndCollections.sets;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by Dmitrii on 24.05.2018.
 */
public class NavigableSetMethods {
    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("aa");
        set.add("bb");
        set.add("cc");
        System.out.println(set);// [a, aa, b, bb, c, cc]
        System.out.println(set.floor("a")); // a
        System.out.println(set.ceiling("aaa")); // b
        System.out.println(set.lower("a")); // null
        System.out.println(set.higher("bb")); // c

        // Required:
        // a
        // b
        // null
        // c
    }
}
