package $04FunctionalInterfaces.primitiveStreams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by Dmitrii on 09.02.2018.
 */
public class UsingPrimitiveOptionals {
    public static void main(String[] args) {
        IntStream is = IntStream.rangeClosed(1, 10);
        OptionalDouble average = is.average();
        System.out.println(average.getAsDouble()); // 5.5
        System.out.println(average.orElseGet(() -> Double.NaN)); // 5.5

        LongStream ls = LongStream.of(5, 10);
        long sum = ls.sum();
        System.out.println(sum); // 15

        DoubleStream ds = DoubleStream.generate(() -> Math.PI).limit(10);
        OptionalDouble min = ds.min();
        System.out.println(min.orElse(0)); // 3.14....
    }
}
