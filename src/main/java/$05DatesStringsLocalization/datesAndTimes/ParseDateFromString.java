package $05DatesStringsLocalization.datesAndTimes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dmitrii on 14.11.2018.
 */
public class ParseDateFromString {
    public static void main(String[] args) throws ParseException {
        String dob = "1987-02-23";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dob);
        System.out.println(date); // Mon Feb 23 00:00:00 MSK 1987

    }
}
