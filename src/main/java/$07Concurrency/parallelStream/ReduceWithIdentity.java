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
                .reduce("_", String::concat);
        System.out.println("Result: " + join);
        // Result: _a_b_c_d_e_f_g

        join = vals.stream()
                .reduce("_", String::concat);
        System.out.println("Result: " + join);
        // Result: _abcdefg


    }
}
