package $03GenericsAndCollections.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 17.01.2018.
 */
public class GenericMethods {

    public static <T, U> List<U> convert(List<T> list, U uParam){
        List<U> uList = new ArrayList<>();
        for (T t : list) {
            uList.add(uParam);
        }
        return uList;
    }

    public static void main(String[] args) {
        List<Integer> ints  = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            ints.add(i);
        }
        List<String> strList = convert(ints, "another one int");
        strList.forEach(System.out::println);
        // another one int X 10 times

        List<Double> doubleList = convert(ints, 11.01);
        doubleList.forEach(System.out::println);
        // 11.01 X 10 times
    }
}
