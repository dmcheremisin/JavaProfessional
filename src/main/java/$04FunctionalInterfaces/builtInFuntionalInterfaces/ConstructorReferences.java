package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Dmitrii on 25.05.2018.
 */
public class ConstructorReferences {
    int value;

    public ConstructorReferences() {
        value = 10;
    }

    public ConstructorReferences(int value) {
        this.value = value;
    }

    public void process() {
        System.out.println("Processing " + value);
    }

    public static void main(String[] args) {
        Supplier<ConstructorReferences> supp = ConstructorReferences::new;
        ConstructorReferences mp1 = supp.get();
        mp1.process(); // Processing 10

        Function<Integer, ConstructorReferences> f = ConstructorReferences::new;
        ConstructorReferences mp2 = f.apply(10);
        mp2.process(); // Processing 10
    }
}
