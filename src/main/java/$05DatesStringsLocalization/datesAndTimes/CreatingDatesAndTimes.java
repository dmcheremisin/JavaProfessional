package $05DatesStringsLocalization.datesAndTimes;

import java.time.*;

/**
 * Created by Dmitrii on 13.02.2018.
 */
public class CreatingDatesAndTimes {
    public static void main(String[] args) {
        System.out.println(LocalDate.now()); // 2018-02-13
        System.out.println(LocalTime.now()); // 19:33:23.679
        System.out.println(LocalDateTime.now()); // 2018-02-13T19:33:23.679
        System.out.println(ZonedDateTime.now()); // 2018-02-13T19:33:23.679+03:00[Europe/Moscow]

        // LocalDate
        LocalDate date1 = LocalDate.of(2015, 6, 20);
        LocalDate date2 = LocalDate.of(2015, Month.JUNE, 20);
        System.out.println(date2); // 2015-06-20

        // LocalTime
        LocalTime time1 = LocalTime.of(15, 30);
        LocalTime time2 = LocalTime.of(15, 30, 45);
        LocalTime time3 = LocalTime.of(15, 30, 45, 5500);
        System.out.println(time3); // 15:30:45.000005500

        // LocalDateTime
        LocalDateTime dt1 = LocalDateTime.of(2015, 6, 20, 15, 30);
        LocalDateTime dt2 = LocalDateTime.of(2015, 6, 20, 15, 30, 45);
        LocalDateTime dt3 = LocalDateTime.of(2015, 6, 20, 15, 30, 45, 5500);
        System.out.println(dt3); // 2015-06-20T15:30:45.000005500
        LocalDateTime dt4 = LocalDateTime.of(2015, Month.JUNE, 20, 15, 30);
        LocalDateTime dt5 = LocalDateTime.of(2015, Month.JUNE, 20, 15, 30, 45);
        LocalDateTime dt6 = LocalDateTime.of(2015, Month.JUNE, 20, 15, 30, 45, 5500);
        System.out.println(dt6); // 2015-06-20T15:30:45.000005500
        LocalDateTime dt7 = LocalDateTime.of(date1, time1);
        System.out.println(dt7); // 2015-06-20T15:30

        // ZonedDateTime
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zdt1 = ZonedDateTime.of(2015, 6, 20, 15, 30, 45, 5500, zone);
        ZonedDateTime zdt2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zdt3 = ZonedDateTime.of(dt1, zone);
        System.out.println(zdt1); // 2015-06-20T15:30:45.000005500-04:00[US/Eastern]
        System.out.println(zdt2); // 2015-06-20T15:30-04:00[US/Eastern]
        System.out.println(zdt3); // 2015-06-20T15:30-04:00[US/Eastern]

    }
}
