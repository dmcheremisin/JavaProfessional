package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.BinaryOperator;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
}*/
public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<String> b1 = (str, add) -> str.concat(add);
        BinaryOperator<String> b2 = String::concat;

        System.out.println(b1.apply("cat ", "hunter")); // cat hunter
        System.out.println(b2.apply("cat ", "hunter")); // cat hunter
    }
}
