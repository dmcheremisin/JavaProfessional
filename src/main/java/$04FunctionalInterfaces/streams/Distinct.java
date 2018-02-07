package $04FunctionalInterfaces.streams;

import java.util.stream.Stream;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class Distinct {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct().forEach(System.out::println);
        // duck
        // goose
    }
}
