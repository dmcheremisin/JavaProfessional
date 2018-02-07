package $04FunctionalInterfaces.streams;

import java.util.stream.Stream;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class Map {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("monkey", "gorilla", "ape");
        s.map(String::length).forEach(System.out::println);
        // 6
        // 7
        // 3
    }
}
