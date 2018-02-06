package $04FunctionalInterfaces.streams;

import java.util.stream.Stream;

/**
 * Created by Dmitrii on 06.02.2018.
 */
public class Count {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("monkey", "gorilla", "ape");
        System.out.println(s.count()); // 3
    }
}
