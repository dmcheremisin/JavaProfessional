package $05DatesStringsLocalization.datesAndTimes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

/**
 * Created by Dmitrii on 23.06.2018.
 */
public class DurationVsPeriod {
    public static void main(String[] args) {

        Period p = Period.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1));
        System.out.println(p);
        // P-2Y-9M-22D

        // Duration d = Duration.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1));
        // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds

        Duration d = Duration.between(LocalDateTime.now(), LocalDateTime.of(2015, Month.SEPTEMBER, 1, 10, 10));
        System.out.println(d);
        // PT-24632H-5M-16.482S
    }
}
