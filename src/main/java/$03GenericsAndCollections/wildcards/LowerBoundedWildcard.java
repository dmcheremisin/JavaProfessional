package $03GenericsAndCollections.wildcards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 18.01.2018.
 */
public class LowerBoundedWildcard {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);

        List<? super String> stringsSound = addSound(strings);
        List<? super String> objectsSound = addSound(objects);

        System.out.println(stringsSound); // [tweet, quack]
        System.out.println(objectsSound); // [tweet, quack]

        List<Object> strs = add(strings);
        List<Object> objs = add(objects);

        System.out.println(strs); // [tweet, quack, quick]
        System.out.println(objs); // [tweet, quack, quick]
    }

    // 1. Here is not possible to modify list -> list.add("quack");
    /*private static void addSound(List<?> list) {
        list.add("quack");
    }*/

    // 2. Impossible to modify list -> list.add("quack");
    /*private static void addSound(List<? extends Object> list) {
        list.add("quack");
    }*/

    // 3. This method can't accept List<String>
    /*private static void addSound(List<Object> list) {
        list.add("quack");
    }*/


    // 4. This method has a lower bound -> List<? super String> list
    // it is possible to accept with it String and Object
    // also it is possible to modify collection with it
    private static List<? super String> addSound(List<? super String> list) {
        list.add("quack");
        return list;
    }

    // This method also fine - it accepts both collections and can modify them
    private static List<Object> add(List list) {
        list.add("quick");
        return list;
    }
}
