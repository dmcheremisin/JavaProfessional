package $05DatesStringsLocalization.datesAndTimes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by Dmitrii on 15.02.2018.
 */
public class DurationExample {
    public static void main(String[] args) {
        // creation
        Duration day = Duration.ofDays(1);
        System.out.println(day); // PT24H
        Duration hour = Duration.ofHours(1);
        System.out.println(hour); // PT1H
        Duration minute = Duration.ofMinutes(1);
        System.out.println(minute); // PT1M
        Duration second = Duration.ofSeconds(1);
        System.out.println(second); // PT1S
        Duration millis = Duration.ofMillis(1);
        System.out.println(millis); // PT0.001S
        Duration nanos = Duration.ofNanos(1);
        System.out.println(nanos); // PT0.000000001S

        // analog with ChronoUnit
        day = Duration.of(1, ChronoUnit.DAYS);
        hour = Duration.of(1, ChronoUnit.HOURS);
        minute = Duration.of(1, ChronoUnit.MINUTES);
        second = Duration.of(1, ChronoUnit.SECONDS);
        millis = Duration.of(1, ChronoUnit.MILLIS);
        nanos = Duration.of(1, ChronoUnit.NANOS);

        Duration halfDay = Duration.of(3, ChronoUnit.HALF_DAYS);
        System.out.println(halfDay); //PT36H

        // difference between time
        LocalTime one = LocalTime.of(4, 30);
        LocalTime two = LocalTime.of(6, 15);
        LocalDate date = LocalDate.of(2015, 10 ,24);
        System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
        System.out.println(ChronoUnit.MINUTES.between(one, two)); // 105
        // System.out.println(ChronoUnit.MINUTES.between(one, date)); DateTimeException

        LocalDateTime dt = LocalDateTime.of(date, one);
        System.out.println(dt); // 2015-10-24T04:30
        System.out.println(dt.plus(day)); // 2015-10-25T04:30
        System.out.println(one.plus(hour)); // 05:30

        Duration d = Duration.ofHours(23);
        System.out.println(dt.plus(d)); // 2015-10-25T03:30
        //date.plus(d); UnsupportedTemporalTypeException: Unsupported unit: Seconds

    }
}
