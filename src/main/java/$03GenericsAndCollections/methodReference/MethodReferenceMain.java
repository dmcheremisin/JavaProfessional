package $03GenericsAndCollections.methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Dmitrii on 29.01.2018.
 */
public class MethodReferenceMain {
    public static void main(String[] args) {
        // static methods
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda = list -> Collections.sort(list);

        // instance method on a particular instance
        String str = "string";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s-> str.startsWith(s);

        // instance methods on an instance to be determined at runtime
        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        // constructors
        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();
    }
}
