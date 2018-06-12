package $07Concurrency.threadCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmitrii on 12.06.2018.
 */
public class ParallelStream {
    public static void main(String[] args) {
        ArrayList<Integer> source = new ArrayList<Integer>();
        source.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> destination = Collections.synchronizedList(new ArrayList<Integer>());

        source.parallelStream()
                .peek(item -> destination.add(item))
                .forEachOrdered(System.out::print);
        System.out.println("");

        destination.stream()
                .forEachOrdered(System.out::print);
        System.out.println("");
        //123456
        //163245
    }
}
