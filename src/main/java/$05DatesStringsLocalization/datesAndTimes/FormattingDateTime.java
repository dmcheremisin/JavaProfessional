package $05DatesStringsLocalization.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by Dmitrii on 18.02.2018.
 */
public class FormattingDateTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 11, 23);
        LocalTime time = LocalTime.of(15, 34);
        LocalDateTime dt = LocalDateTime.of(date, time);

        // ISO format
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));//2020-11-23
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));// 15:34:00
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));// 2020-11-23T15:34:00

        // predefined SHORT format
        DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        System.out.println(shortFormat.format(date)); // 23.11.20
        System.out.println(date.format(shortFormat)); // 23.11.20

        System.out.println(shortFormat.format(dt)); // 23.11.20
        System.out.println(dt.format(shortFormat)); // 23.11.20
        // System.out.println(shortFormat.format(time)); -> UnsupportedTemporalTypeException

        DateTimeFormatter shortTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(shortTime.format(time)); // 15:34
        System.out.println(time.format(shortTime)); // 15:34

        DateTimeFormatter shortDt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(shortDt.format(dt)); // 23.11.20 15:34
        System.out.println(dt.format(shortDt)); // 23.11.20 15:34

        // MEDIUM format
        DateTimeFormatter medium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(dt.format(medium)); // 23.11.2020 15:34:00
        System.out.println(medium.format(dt)); // 23.11.2020 15:34:00

        // custom formats
        DateTimeFormatter custom = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dt.format(custom)); // ноября 23, 2020, 03:34
        DateTimeFormatter custom2 = DateTimeFormatter.ofPattern("dd.MM.yyyy, E, HH:mm:ss");
        System.out.println(custom2.format(dt)); // 23.11.2020, Пн, 15:34:00

        // parsing
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        LocalDateTime customDT = LocalDateTime.parse("11.01.1989, 20:30", parseFormat);
        System.out.println(customDT.format(custom2)); // 11.01.1989, Ср, 20:30:00

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Date : " + pattern.format(LocalDate.now()));


    }
}
