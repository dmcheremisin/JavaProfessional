package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 06.02.2018.
 */
public class StreamCreation {
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<Integer> single = Stream.of(1);
        Stream<Integer> three = Stream.of(1, 2, 3);
        //Stream<Integer> four = Stream.of(new int[]{1, 2, 3, 4}); doesn't work
        System.out.println(three.count()); // 3

        // from list
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> fromList = list.stream();
        Stream<Integer> fromListParallel = list.parallelStream();

        // infinite streams
        Stream<Double> generate = Stream.generate(Math::random);
        Stream<Integer> iterate = Stream.iterate(1, i -> i + 2);

    }
}
