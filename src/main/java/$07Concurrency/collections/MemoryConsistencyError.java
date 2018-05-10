package $07Concurrency.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryConsistencyError {

    private static void checkHashMap() {
        try {
            Map<String, Object> foodData = new HashMap<>();
            foodData.put("penguin", 1);
            foodData.put("flamingo", 2);
            for (String key : foodData.keySet())
                foodData.remove(key);
        }catch (Exception e){
            System.out.println("HashMap exception: " + e);
        }
    }

    private static void checkConcurrentHashMap() {
        try {
            Map<String, Object> foodData = new ConcurrentHashMap<>();
            foodData.put("penguin", 1);
            foodData.put("flamingo", 2);
            for (String key : foodData.keySet())
                foodData.remove(key);
        }catch (Exception e){
            System.out.println("ConcurrentHashMap exception: " + e);
        }
    }

    public static void main(String[] args) {
        checkHashMap();
        checkConcurrentHashMap();
    }
    // HashMap exception: java.util.ConcurrentModificationException
    // so for ConcurrentHashMap is fine
}
