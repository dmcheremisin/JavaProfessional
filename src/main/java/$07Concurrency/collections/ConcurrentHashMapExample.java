package $07Concurrency.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        Map<String, Object> foodData = new HashMap<>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for(String key: foodData.keySet()) {
            // foodData.remove(key); -> throws  ConcurrentModificationException
        }

        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("penguin", 1);
        concurrentHashMap.put("flamingo", 2);
        for(String key: concurrentHashMap.keySet()) {
            foodData.remove(key); // works fine
        }
    }
}
