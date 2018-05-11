package $07Concurrency.collections;

import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Dmitrii on 11.05.2018.
 */
public class CollectionsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));

        Queue<String> blockingQueue = new LinkedBlockingQueue<>(); // the same ConcurrentLinkedQueue
        blockingQueue.offer("one");
        blockingQueue.add("two");
        System.out.println(blockingQueue); // [one, two]
        System.out.println(blockingQueue.peek()); // one
        System.out.println(blockingQueue.poll()); // one
        System.out.println(blockingQueue); // [two]

        Deque<String> blockingDeque = new LinkedBlockingDeque<>(); // ConcurrentLinkedDeque
        blockingDeque.offer("one");
        blockingDeque.add("two");
        blockingDeque.push("three");
        System.out.println(blockingDeque); // [three, one, two]
        System.out.println(blockingDeque.peek()); // three
        System.out.println(blockingDeque.poll()); // three
        System.out.println(blockingDeque); // [one, two]
        
        
    }
}
