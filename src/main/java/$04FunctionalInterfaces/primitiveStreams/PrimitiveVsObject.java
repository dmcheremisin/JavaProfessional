package $04FunctionalInterfaces.primitiveStreams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * Created by Dmitrii on 08.02.2018.
 */
public class PrimitiveVsObject {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        System.out.println(ints.stream().reduce(0, (i1, i2) -> i1 + i2)); // 6
        // VS
        System.out.println(ints.stream().mapToInt(x -> x).sum()); // 6

        IntStream intStream = ints.stream().mapToInt(x -> x);
        OptionalDouble average = intStream.average();
        System.out.println(average); // OptionalDouble[2.0]
        System.out.println(average.getAsDouble()); // 2.0
    }
}
