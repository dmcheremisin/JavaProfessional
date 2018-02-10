package $04FunctionalInterfaces.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 10.02.2018.
 */
public class LinkingStreamToData {
    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");
        Stream<String> stream = cats.stream();
        cats.add("Margo");
        System.out.println(stream.count()); // 3
    }
}
