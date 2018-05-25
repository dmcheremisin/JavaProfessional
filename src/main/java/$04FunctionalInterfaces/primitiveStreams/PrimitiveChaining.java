package $04FunctionalInterfaces.primitiveStreams;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * Created by Dmitrii on 25.05.2018.
 */
public class PrimitiveChaining {
    public static int operate(IntUnaryOperator iuo) {
        return iuo.applyAsInt(5);
    }

    public static void main(String[] args) {
        IntFunction<IntUnaryOperator> chain1 = a -> b -> a - b;
        // the same as:
        IntFunction<IntUnaryOperator> chain2 = a -> {
            IntUnaryOperator intUnaryOperator = b -> a - b;
            return intUnaryOperator;
        };
        int x1 = operate(chain1.apply(20));
        int x2 = operate(chain2.apply(20));
        System.out.println(x1); // 15
        System.out.println(x2); // 15
    }
}
