package $04FunctionalInterfaces.common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitrii on 23.06.2018.
 */
public class FindingMaxValue {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);

        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b)->a>b?a:b)); //9
        System.out.println(ls.stream().max(Integer::max).get()); //3
        System.out.println(ls.stream().max(Integer::compare).get()); //9
        System.out.println(ls.stream().max((a, b)->a>b?a:b)); //Optional[3]
    }

    // Integer's compare method
    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    // Integer's max method
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

}
