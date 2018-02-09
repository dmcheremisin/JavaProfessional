package $04FunctionalInterfaces.primitiveStreams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * Created by Dmitrii on 09.02.2018.
 */
public class SummaryStatistics {
    public static void main(String[] args) {
        IntStream is = IntStream.rangeClosed(1, 10);
        IntSummaryStatistics stats = is.summaryStatistics();

        double average = stats.getAverage();
        int max = stats.getMax();
        int min = stats.getMin();
        long sum = stats.getSum();
        long count = stats.getCount();

        System.out.println(average + " " + max + " " + min + " " + sum + " " + count);
        // 5.5 10 1 55 10
    }
}
