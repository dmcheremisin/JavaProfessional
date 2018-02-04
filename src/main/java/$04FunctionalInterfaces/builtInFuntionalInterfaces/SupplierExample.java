package $04FunctionalInterfaces.builtInFuntionalInterfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Dmitrii on 04.02.2018.
 */
/*@FunctionalInterface
public interface Supplier<T> {

    *//**
     * Gets a result.
     *
     * @return a result
     *//*
    T get();
}*/
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<LocalDate> d1 = () -> LocalDate.now();
        Supplier<LocalDate> d2 = LocalDate::now;

        System.out.println(d1.get());
        System.out.println(d2.get());
        // 2018-02-04
        // 2018-02-04

        Supplier<ArrayList<String>> list1 = () -> new ArrayList<>();
        Supplier<ArrayList<String>> list2 = ArrayList<String>::new;
        Supplier<List<String>> list3 = ArrayList::new;

        List<String> arrayList = list3.get();
        arrayList.add("First str");
        arrayList.add("Second str");
        System.out.println(arrayList);
        // [First str, Second str]
        System.out.println(list2);
        // $04FunctionalInterfaces.builtInFuntionalInterfaces.SupplierExample$$Lambda$7/1791741888@3feba861
    }
}
