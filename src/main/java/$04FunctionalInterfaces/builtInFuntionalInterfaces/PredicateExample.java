package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.Predicate;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface Predicate<T> {

    *//**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     *//*
    boolean test(T t);
}*/
public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.isEmpty();
        Predicate<String> p2 = String::isEmpty;

        System.out.println(p1.test("yahooo")); // false
        System.out.println(p2.test("")); // true

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> eggAndBrown = egg.and(brown);
        Predicate<String> eggAndNotBrown = egg.and(brown.negate());

        System.out.println(eggAndBrown.test("brown eggs")); // true
        System.out.println(eggAndBrown.test("pink egg")); // false
        System.out.println(eggAndNotBrown.test("brown eggs")); // false
        System.out.println(eggAndNotBrown.test("white eggs")); // true
    }
}
