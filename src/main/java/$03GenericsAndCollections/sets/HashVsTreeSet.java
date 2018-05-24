package $03GenericsAndCollections.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Dmitrii on 19.01.2018.
 */
public class HashVsTreeSet {
    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(66);
        hashSet.add(66);
        hashSet.add(8);
        System.out.println(hashSet);
        // [66, 8, 10]

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(66);
        treeSet.add(66);
        treeSet.add(8);
        System.out.println(treeSet);
        // [8, 10, 66]
    }
}