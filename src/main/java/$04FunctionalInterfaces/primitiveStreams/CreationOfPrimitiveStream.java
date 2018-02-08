package $04FunctionalInterfaces.primitiveStreams;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 08.02.2018.
 */
public class CreationOfPrimitiveStream {
    public static void main(String[] args) {
        // 1. empty stream
        DoubleStream empty = DoubleStream.empty();

        // 2. factory method
        DoubleStream one = DoubleStream.of(Math.PI);
        DoubleStream three = DoubleStream.of(1,2,3);

        one.forEach(System.out::println); // 3.14....
        three.forEach(System.out::println); // 1.0 2.0 3.0

        // 3. methods
        DoubleStream gen = DoubleStream.generate(() -> LocalTime.now().getSecond()*1.5);
        DoubleStream it = DoubleStream.iterate(0.5, v -> v*1.5);

        // 4. range for IntStream and LongStream
        LongStream range = LongStream.range(1, 6);// 1 2 3 4 5
        LongStream rangeClosed = LongStream.rangeClosed(1, 6);// 1 2 3 4 5 6

        // 5. mapping from another stream type
        List<String> animals = Arrays.asList("penguine", "sheep", "elephant");
        IntStream intStream = animals.stream().mapToInt(v -> v.length());
        DoubleStream doubleStream = animals.stream().mapToDouble(v -> v.length() / 2);
        // back to stream of strings
        Stream<String> stringStream = doubleStream.mapToObj(v -> "value = " + v);

        // 6. from flatMap
        IntStream intStream1 = animals.stream().flatMapToInt(v -> IntStream.of(v.length()));
        IntStream intStream2 = Stream.of(animals, animals).flatMapToInt(v -> v.stream().mapToInt(a -> a.length()));
    }
}
