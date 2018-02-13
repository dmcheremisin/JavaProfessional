package $05DatesStringsLocalization.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

/**
 * Created by Dmitrii on 13.02.2018.
 */
public class CreatingDatesAndTimes {
    public static void main(String[] args) {
        System.out.println(LocalDate.now()); // 2018-02-13
        System.out.println(LocalTime.now()); // 19:33:23.679
        System.out.println(LocalDateTime.now()); // 2018-02-13T19:33:23.679
        System.out.println(ZonedDateTime.now()); // 2018-02-13T19:33:23.679+03:00[Europe/Moscow]

    }
}
