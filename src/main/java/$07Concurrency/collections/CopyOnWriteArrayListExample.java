package $07Concurrency.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
        for(Integer item: list) {
            System.out.print(item+" ");
            list.add(9);
        }
        // Outputs -> 4 3 52
        System.out.println();
        System.out.println("Size: "+list.size());
        // Outputs -> Size: 6

        for(Integer item: list) {
            System.out.print(item+" ");
        }
        // Outputs -> 4 3 52 9 9 9
    }
}
