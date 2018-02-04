package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.BiFunction;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface BiFunction<T, U, R> {

    *//**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @return the function result
     *//*
    R apply(T t, U u);
}*/
public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> b1 = (str, i) -> str.concat(i.toString());
        BiFunction<String, String, String> b2 = String::concat;

        System.out.println(b1.apply("number ", 1)); // number 1
        System.out.println(b2.apply("number ", "one")); // number one
    }
}
