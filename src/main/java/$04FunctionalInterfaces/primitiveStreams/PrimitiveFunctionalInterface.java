package $04FunctionalInterfaces.primitiveStreams;

import java.util.function.DoubleToIntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

/**
 * Created by Dmitrii on 10.02.2018.
 */
public class PrimitiveFunctionalInterface {
    public static void main(String[] args) {
        double d = 3.6;
        DoubleToIntFunction toInt = x -> (int) x;
        System.out.println(toInt.applyAsInt(d)); // 3

        String name = "Hunter";
        ToDoubleFunction<String> toDouble = str -> (double) str.length();
        System.out.println(toDouble.applyAsDouble(name)); // 6.0

        ToDoubleBiFunction<String, String> biDouble = (s1, s2) -> s1.length() + s2.length();
        System.out.println(biDouble.applyAsDouble(name, name)); // 12.0

        ObjDoubleConsumer<String> doubleConsumer = (str, doub) -> System.out.println(str.length() + doub);
        doubleConsumer.accept(name, 1); // 7.0

    }
}
