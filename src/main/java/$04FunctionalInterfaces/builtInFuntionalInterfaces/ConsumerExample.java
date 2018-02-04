package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.Consumer;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface Consumer<T> {

    *//**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     *//*
    void accept(T t);
}*/
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println;

        c1.accept("String 1");
        c2.accept("String 2");
        // String 1
        // String 2
    }
}
