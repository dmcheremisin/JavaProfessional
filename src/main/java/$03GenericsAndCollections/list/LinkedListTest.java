package $03GenericsAndCollections.list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListTest {
    public static void main(String[] args) {
        // FIFO
        Queue<Integer> queue = new LinkedList<>();
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
        Deque<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList); // [1, 2]
        linkedList.offer(3);
        linkedList.offer(4);
        System.out.println(linkedList); // [1, 2, 3, 4]
        linkedList.push(5);
        linkedList.push(6);
        System.out.println(linkedList); // [6, 5, 1, 2, 3, 4]

        System.out.println(linkedList.peek()); // 6

        System.out.println(linkedList.pop()); // 6
        System.out.println(linkedList.pop()); // 5
        System.out.println(linkedList.poll()); // 1
        System.out.println(linkedList.poll()); // 2

        System.out.println(linkedList.peek()); // 1
    }
}
