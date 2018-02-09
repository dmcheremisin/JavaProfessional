package $04FunctionalInterfaces.primitiveStreams;

import java.util.function.BooleanSupplier;

/**
 * Created by Dmitrii on 09.02.2018.
 */
public class BooleanSupplierExample {
    public static void main(String[] args) {
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;
        System.out.println(b1.getAsBoolean()); // true
        System.out.println(b2.getAsBoolean()); // true
    }
}
