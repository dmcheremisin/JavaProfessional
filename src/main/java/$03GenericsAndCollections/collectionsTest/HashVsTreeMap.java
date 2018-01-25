package $03GenericsAndCollections.collectionsTest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Dmitrii on 19.01.2018.
 */
public class HashVsTreeMap {
    public static void main(String[] args) {

        Map<String, String> hash = new HashMap<>();
        System.out.println(hash.put("koala", "bamboo")); // null
        System.out.println(hash.put("koala", "eucalyptus")); // bamboo
        System.out.println(hash.put("lion", "meat")); // null
        System.out.println(hash.put("giraffe", "leaf")); // null
        System.out.println(hash);
        // {koala=eucalyptus, giraffe=leaf, lion=meat}

        Map<String, String> tree = new TreeMap<>();
        System.out.println(tree.put("koala", "bamboo")); // null
        System.out.println(tree.put("koala", "eucalyptus")); // bamboo
        System.out.println(tree.put("lion", "meat")); // null
        System.out.println(tree.put("giraffe", "leaf")); // null
        System.out.println(tree);
        // {giraffe=leaf, koala=eucalyptus, lion=meat}
    }
}
