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

        System.out.println(queue.peek()); // 3

        System.out.println(" ================== ");

        // LIFO
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        System.out.println(arrayDeque); // [1, 2]
        arrayDeque.offer(3);
        arrayDeque.offer(4);
        System.out.println(arrayDeque); // [1, 2, 3, 4]
        arrayDeque.push(5);
        arrayDeque.push(6);
        System.out.println(arrayDeque); // [6, 5, 1, 2, 3, 4]

        System.out.println(arrayDeque.peek()); // 6

        System.out.println(arrayDeque.poll()); // 6
        System.out.println(arrayDeque.poll()); // 5

        System.out.println(arrayDeque.peek()); // 1

    }
}
