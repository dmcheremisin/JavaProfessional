package $07Concurrency.collections;

import $07Concurrency.Utils;

import java.util.*;

public class SynchronizedCollectionMethods {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("one", "two", "three");
        Collection<String> collection = Collections.synchronizedCollection(list);
        List<String> syncList = Collections.synchronizedList(list);
        //syncList.add("four"); -> UnsupportedOperationException
        // list.add("four"); -> UnsupportedOperationException

        TreeSet<String> set = new TreeSet<>();
        set.add("one");
        set.add("two");
        Set<String> syncSet = Collections.synchronizedSet(set);
        SortedSet<String> sortedSet = Collections.synchronizedSortedSet(set);
        NavigableSet<String> navSet = Collections.synchronizedNavigableSet(set);
        syncSet.add("three");

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("one", 1);
        map.put("two", 2);
        Map<String, Integer> syncMap = Collections.synchronizedMap(map);
        SortedMap<String, Integer> sortedMap = Collections.synchronizedSortedMap(map);
        NavigableMap<String, Integer> navMap = Collections.synchronizedNavigableMap(map);

        // BUT! synchronized collections should be used with synchronized block if you need to iterate over it:
        // they do not synchronize entire data, only get and set methods
        synchronized (syncSet){
            for(String str : syncSet){
                System.out.println(str);
                //syncSet.add("new"); //-> ConcurrentModificationException
            }
//            one
//            three
//            two
            System.out.println(syncSet); // [one, three, two]
       }
        new Thread(() -> { syncSet.add("four");}).start();
        new Thread(() -> { syncSet.add("five");}).start();
        new Thread(() -> { syncSet.add("six");}).start();
        Utils.pause(4000);
        System.out.println(syncSet); // [five, four, one, six, three, two]

    }
}
