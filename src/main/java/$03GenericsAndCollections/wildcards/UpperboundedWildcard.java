package $03GenericsAndCollections.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 18.01.2018.
 */
public class UpperboundedWildcard {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>(){{
            add(1); add(2); add(3);
        }};
        System.out.println(sum(list));
        // 6.0

        // List<? extends Double> list1 = new ArrayList<Integer>();
        // incompatible types

        List<? extends Double> list2 = new ArrayList<Double>(){{
            add(1.0); add(.2); add(3.0);
        }};
        System.out.println(sum(list2));
        // 4.2
    }


    public static Double sum(List<? extends Number> list) {
        Double doub = 0.0;
        for(Number num : list) {
            doub += num.doubleValue();
        }
        return doub;
    }
}
