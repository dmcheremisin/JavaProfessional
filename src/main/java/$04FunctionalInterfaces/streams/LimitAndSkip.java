package $04FunctionalInterfaces.streams;

import java.util.stream.Stream;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class LimitAndSkip {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.iterate(1, n -> n + 1);
        s.skip(5).limit(2).forEach(System.out::println);
        // 6
        // 7
    }
}
