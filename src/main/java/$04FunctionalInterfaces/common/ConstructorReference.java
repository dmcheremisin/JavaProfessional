package $04FunctionalInterfaces.common;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Dmitrii on 23.06.2018.
 */
public class ConstructorReference {
    public int value;
    public ConstructorReference(int value) {
        this.value = value;
    }
    public void print(){
        System.out.print(value + ", ");
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        list.stream()
                .map(ConstructorReference::new)
                .forEach(ConstructorReference::print);
        // 1, 2, 3,

        System.out.println();

        Function<Integer, ConstructorReference> f1 = ConstructorReference::new;
        list.stream()
                .map(f1)
                .forEach(ConstructorReference::print);
        // 1, 2, 3,

        System.out.println();

        Function<Integer, ConstructorReference> f2 = value -> new ConstructorReference(value);
        list.stream()
                .map(f1)
                .forEach(ConstructorReference::print);
        // 1, 2, 3,
    }
}
