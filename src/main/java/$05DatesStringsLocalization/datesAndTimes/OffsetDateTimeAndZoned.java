package $05DatesStringsLocalization.datesAndTimes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Created by Dmitrii on 10.06.2018.
 */
public class OffsetDateTimeAndZoned {

    // Given :
    // 1. The time zone of America/New York is normally 5 hours behind UTC.
    // 2. Day light saving is ON during June in New York. (This means, clocks in New York are 1 hour ahead than when day light saving is OFF.)

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2017, 06, 02, 6, 0, 0);
        System.out.println(ldt); // 2017-06-02T06:00

        ZoneOffset nyOffset = ZoneOffset.ofHoursMinutes(-5, 0);
        ZoneId nyZone = ZoneId.of("America/New_York");

        OffsetDateTime nyOdt = ldt.atOffset(nyOffset);
        System.out.println(nyOdt); // 2017-06-02T06:00-05:00

        ZonedDateTime nyZdt = ldt.atZone(nyZone);
        System.out.println(nyZdt); // 2017-06-02T06:00-04:00[America/New_York]

        Duration d = Duration.between(nyOdt, nyZdt);
        System.out.println(d); // PT-1H
    }
}
