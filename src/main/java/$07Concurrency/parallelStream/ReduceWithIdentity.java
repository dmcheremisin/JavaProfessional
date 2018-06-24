package $07Concurrency.parallelStream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitrii on 24.06.2018.
 */
public class ReduceWithIdentity {
    public static void main(String[] args) {
        List<String> vals = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        String join = vals.parallelStream()
                .peek(System.out::println)
                .reduce("_", String::concat, (a, b) -> a.concat(b));
        System.out.println("Result: " + join);
        //a
        //c
        //b
        //e
        //f
        //g
        //d
        // Result: _a_b_c_d_e_f_g
    }
}
