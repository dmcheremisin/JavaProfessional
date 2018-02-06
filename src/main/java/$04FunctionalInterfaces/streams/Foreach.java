package $04FunctionalInterfaces.streams;

import java.util.stream.Stream;

/**
 * Created by Dmitrii on 06.02.2018.
 */
public class Foreach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("monkey", "gorilla", "ape");
        stream.forEach(System.out::println);
//        monkey
//        gorilla
//        ape
    }
}
