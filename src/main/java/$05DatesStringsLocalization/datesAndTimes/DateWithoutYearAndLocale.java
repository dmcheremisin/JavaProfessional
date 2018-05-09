package $05DatesStringsLocalization.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateWithoutYearAndLocale {
    public static void main(String[] args) {
        String time = "14:30 Sat 05 May";
        time +=  " " + LocalDate.now().getYear();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm EEE dd MMM yyyy", Locale.US);
        LocalDateTime formatDateTime = LocalDateTime.parse(time, formatter);

        System.out.println(formatDateTime);
        //2018-05-05T14:30
    }
}
