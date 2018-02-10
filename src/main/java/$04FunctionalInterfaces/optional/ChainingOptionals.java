package $04FunctionalInterfaces.optional;

import java.util.Optional;

/**
 * Created by Dmitrii on 10.02.2018.
 */
public class ChainingOptionals {
    public static void main(String[] args) {
        Optional<Integer> num = Optional.of(345);
        nonFunctionalPrint(num); // 345
        functionalPrint(num); // 345
    }

    // non-functional approach
    private static void nonFunctionalPrint(Optional<Integer> optional) {
        if (optional.isPresent()) {
            Integer num = optional.get();
            String str = "" + num;
            if (str.length() == 3) {
                System.out.println(str);
            }
        }
    }

    // functional approach
    private static void functionalPrint(Optional<Integer> optional) {
        optional.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }
}
