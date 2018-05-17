package $07Concurrency.parallelStream;

import java.util.Arrays;
import java.util.List;

public class ProcessingParallel {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().forEach(i -> System.out.print(i + " ")); // 1 2 3 4 5
        System.out.println();

        list.parallelStream().forEach(i -> System.out.print(i + " ")); // 3 5 4 2 1
        System.out.println();

    }
}
