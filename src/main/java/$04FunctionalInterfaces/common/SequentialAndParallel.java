package $04FunctionalInterfaces.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 27.06.2018.
 */
public class SequentialAndParallel {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        Stream<Integer> strm = list.stream().filter(i-> i>5 && i<15);  //2
        strm.forEach(System.out::print);
        // 71113
        System.out.println();
        Stream<Integer> strm2 = list.stream().parallel().filter(i->i>5).filter(i->i<15).sequential();
        strm2.forEach(System.out::print);
        // 71113
    }
}
