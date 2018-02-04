package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.Function;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface Function<T, R> {

    *//**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     *//*
    R apply(T t);
}*/
public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> f1 = s -> s.length();
        Function<String, Integer> f2 = String::length;

        System.out.println(f1.apply("yahooo")); // 6
        System.out.println(f2.apply("yahooo")); // 6

    }
}
