package $04FunctionalInterfaces.optional;

import java.util.Optional;

/**
 * Created by Dmitrii on 05.02.2018.
 */
public class OptionalExamples {
    public static void main(String[] args) {
        Optional<Double> avr = average(90, 100);
        System.out.println(avr); // Optional[95.0]
        Optional<Double> noAvr = average();
        System.out.println(noAvr); // Optional.empty

        if(avr.isPresent()) System.out.println(avr.get()); // 95.0
        avr.ifPresent(System.out::println); // 95.0
        //System.out.println(noAvg.get()); -> Exception in thread "main" java.util.NoSuchElementException: No value present

        // Optional.of(null); -> Exception in thread "main" java.lang.NullPointerException
        String value = null;
        Optional o = value == null ? Optional.empty() : Optional.of(value);
        // it is equivalent to:
        Optional ofNullable = Optional.ofNullable(value);
        System.out.println(ofNullable.isPresent()); // false
        System.out.println(ofNullable); // Optional.empty

        System.out.println(noAvr.orElse(Double.NaN)); // Nan
        System.out.println(noAvr.orElseGet(() -> Math.random())); // 0.7814148641924566
        // System.out.println(noAvr.orElseThrow(() -> new IllegalArgumentException())); -> Exception in thread "main" java.lang.IllegalArgumentException
        System.out.println(avr.orElse(Double.NaN)); // 95.0
    }
    public static Optional<Double> average(int... nums){
        if(nums == null || nums.length == 0) {
            return Optional.empty();
        } else {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return Optional.of((double) sum / nums.length);
        }
    }
}
