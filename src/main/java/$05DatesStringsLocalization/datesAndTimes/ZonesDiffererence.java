package $05DatesStringsLocalization.datesAndTimes;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by Dmitrii on 10.06.2018.
 */
public class ZonesDiffererence {
    // Daylight Savings Time starts on March 8th at 2 AM in US/Eastern time zone
    public static void main(String[] args) {
        LocalDateTime ld1 = LocalDateTime.of(2015, Month.MARCH, 8, 2, 0);
        System.out.println((ld1)); // 2015-03-08T02:00
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
        System.out.println(zd1); // 2015-03-08T03:00-04:00[US/Eastern]

        LocalDateTime ld2 = LocalDateTime.of(2015, Month.MARCH, 8, 3, 0);
        System.out.println(ld2); // 2015-03-08T03:00
        ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
        System.out.println(zd2); // 2015-03-08T03:00-04:00[US/Eastern]

        long x = ChronoUnit.HOURS.between(zd1, zd2);
        System.out.println(x); // 0
    }
}
