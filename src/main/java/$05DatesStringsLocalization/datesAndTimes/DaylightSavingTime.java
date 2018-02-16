package $05DatesStringsLocalization.datesAndTimes;

import java.time.*;

/**
 * Created by Dmitrii on 16.02.2018.
 */
public class DaylightSavingTime {
    public static void main(String[] args) {
        LocalDate march = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");

        // forward
        ZonedDateTime zoneMarch = ZonedDateTime.of(march, time, zone);
        System.out.println(zoneMarch); // 2016-03-13T01:30-05:00[US/Eastern]
        System.out.println(zoneMarch.plusHours(1)); // 2016-03-13T03:30-04:00[US/Eastern]

        // backward
        LocalDate november = LocalDate.of(2016, Month.NOVEMBER, 6);
        ZonedDateTime zoneNov = ZonedDateTime.of(november, time, zone);
        System.out.println(zoneNov); // 2016-11-06T01:30-04:00[US/Eastern]
        zoneNov = zoneNov.plusHours(1);
        System.out.println(zoneNov); // 2016-11-06T01:30-05:00[US/Eastern]
        zoneNov = zoneNov.plusHours(1);
        System.out.println(zoneNov); // 2016-11-06T02:30-05:00[US/Eastern]
    }
}
