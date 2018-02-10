package $04FunctionalInterfaces.optional;

import java.util.Optional;

/**
 * Created by Dmitrii on 10.02.2018.
 */
public class OptionalMethodReference {
    public static void main(String[] args) {
        Optional<String> str = Optional.of("str");
        Optional<Integer> integer1 = str.map(s -> s.length());
        Optional<Integer> integer2 = str.map(String::length);

        // Optional<Integer> result = str.map(ChainingOptionals::calculator); Doesn't compile
        Optional<Integer> result = str.flatMap(OptionalMethodReference::calculator);
    }

    static Optional<Integer> calculator(String s) {
        return Optional.of(s.length());
    }
}
