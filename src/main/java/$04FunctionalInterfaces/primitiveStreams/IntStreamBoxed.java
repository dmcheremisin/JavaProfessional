package $04FunctionalInterfaces.primitiveStreams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 26.06.2018.
 */
public class IntStreamBoxed {
    public static void main(String[] args) {
        Object obj = IntStream.rangeClosed(10, 15)
                .boxed()
                .peek(System.out::println)
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(obj);
        //10
        //11
        //12
        //13
        //14
        //15
        //{false=[11, 13, 15], true=[10, 12, 14]}
    }
}
