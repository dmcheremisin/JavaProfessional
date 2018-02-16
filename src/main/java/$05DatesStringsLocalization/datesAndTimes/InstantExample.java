package $05DatesStringsLocalization.datesAndTimes;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by Dmitrii on 16.02.2018.
 */
public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now); // 2018-02-16T11:46:31.509Z

        LocalDate ld = LocalDate.of(2017, 06, 24);
        LocalTime lt = LocalTime.of(13, 15);
        ZoneId zId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zdt = ZonedDateTime.of(ld, lt, zId);
        System.out.println(zdt); // 2017-06-24T13:15+03:00[Europe/Moscow]
        Instant instant = zdt.toInstant();
        System.out.println(instant); // 2017-06-24T10:15:00Z

        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt); // 2017-06-24T13:15
        ZoneOffset zoneOffset = ZoneOffset.of("+03:00");
        System.out.println(ldt.toInstant(zoneOffset)); // 2017-06-24T13:15:00Z

        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond); // 1498299300
        Instant epochInstant = Instant.ofEpochSecond(epochSecond);
        // epochInstant == instant

        // instant allows manipulation with units day or smaller
        Duration day = Duration.ofDays(1);
        System.out.println(instant); // 2017-06-24T10:15:00Z
        Instant plus = instant.plus(day);
        plus = instant.plus(1, ChronoUnit.DAYS);
        System.out.println(plus); // 2017-06-25T10:15:00Z
        Instant minus = instant.minus(day);
        minus = instant.minus(1, ChronoUnit.DAYS);
        System.out.println(minus); // 2017-06-23T10:15:00Z
        // Instant week = instant.plus(1, ChronoUnit.WEEKS); -> UnsupportedTemporalTypeException: Unsupported unit: Weeks
    }
}
