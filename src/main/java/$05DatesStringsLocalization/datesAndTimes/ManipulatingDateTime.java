package $05DatesStringsLocalization.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Created by Dmitrii on 15.02.2018.
 */
public class ManipulatingDateTime {
    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2014, Month.JANUARY, 20);
        System.out.println(d); // 2014-01-20
        d = d.plusDays(2);
        System.out.println(d); // 2014-01-22
        d = d.plusWeeks(1);
        System.out.println(d); // 2014-01-29
        d = d.plusMonths(1);
        System.out.println(d); // 2014-02-28, because 2014 is not a leap year(29 Feb doesn't exists)
        d = d.plusYears(5);
        System.out.println(d); // 2019-02-28

        LocalTime t = LocalTime.of(5, 15);

        LocalDateTime dt = LocalDateTime.of(d, t);
        System.out.println(dt); // 2019-02-28T05:15
        dt = dt.minusDays(1);
        System.out.println(dt); // 2019-02-27T05:15
        dt = dt.minusHours(10);
        System.out.println(dt); // 2019-02-26T19:15
        dt = dt.minusSeconds(30);
        System.out.println(dt); // 2019-02-26T19:14:30

        dt = dt.minusDays(1).minusWeeks(1).minusHours(1).minusMinutes(13);
        System.out.println(dt); // 2019-02-18T18:01:30

        LocalTime t2 = LocalTime.of(5, 15);
        t2 = t2.plusHours(2);
        System.out.println(t2);// 07:15
        t2 = t2.plusMinutes(2);
        System.out.println(t2);// 07:17
        t2 = t2.plusNanos(2000);
        System.out.println(t2);// 07:17:00.000002

    }
}
