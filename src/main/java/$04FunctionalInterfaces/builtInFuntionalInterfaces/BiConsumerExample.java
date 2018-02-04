package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface BiConsumer<T, U> {

    *//**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     *//*
    void accept(T t, U u);
}*/
public class BiConsumerExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> bic1 = (k, v) -> map.put(k,v);
        BiConsumer<String, Integer> bic2 = map::put;

        bic1.accept("first", 1);
        bic2.accept("second", 2);

        System.out.println(map);
        //{first=1, second=2}
    }
}
