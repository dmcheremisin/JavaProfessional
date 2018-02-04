package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.UnaryOperator;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
}*/
public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<String> u1 = str -> str.toUpperCase();
        UnaryOperator<String> u2 = String::toUpperCase;

        System.out.println(u1.apply("Chicken")); // CHICKEN
        System.out.println(u2.apply("Chicken")); // CHICKEN

    }
}
