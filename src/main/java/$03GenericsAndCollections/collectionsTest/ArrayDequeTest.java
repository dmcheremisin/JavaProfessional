package $03GenericsAndCollections.collectionsTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ArrayDequeTest {

    public static void main(String[] args) {
        // FIFO
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue); // [1, 2, 3, 4]
        // queue.push(5); no push method

        System.out.println(queue.peek()); // 1 shows current element

        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
        // queue.pop(); no pop method

        System.out.println(queue.peek()); // 3

        System.out.println(" ================== ");

        // LIFO
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        System.out.println(deque); // [1, 2]
        deque.offer(3);
        deque.offer(4);
        System.out.println(deque); // [1, 2, 3, 4]
        deque.push(5);
        deque.push(6);
        System.out.println(deque); // [6, 5, 1, 2, 3, 4]

        System.out.println(deque.peek()); // 6

        System.out.println(deque.pop()); // 6
        System.out.println(deque.pop()); // 5
        System.out.println(deque.poll()); // 1
        System.out.println(deque.poll()); // 2

        System.out.println(deque.peek()); // 3

    }
}
