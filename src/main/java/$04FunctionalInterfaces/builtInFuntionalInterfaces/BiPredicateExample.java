package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.BiPredicate;

/**
 * Created by Dmitrii on 04.02.2018.
 */
public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, String> b1 = (str, pref) -> str.startsWith(pref);
        BiPredicate<String, String> b2 = String::startsWith;

        System.out.println(b1.test("chicken", "chick")); // true
        System.out.println(b2.test("chicken", "chick")); // true
    }
}
