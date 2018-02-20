package $05DatesStringsLocalization.numberFormats;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Dmitrii on 20.02.2018.
 */
public class FormatNumbers {
    public static void main(String[] args) {
        int attendees = 3_200_000;
        NumberFormat ru = NumberFormat.getInstance();
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        NumberFormat german = NumberFormat.getInstance(Locale.GERMAN);
        NumberFormat french = NumberFormat.getInstance(Locale.FRENCH);
        System.out.println(ru.format(attendees)); // 3 200 000
        System.out.println(us.format(attendees)); // 3,200,000
        System.out.println(german.format(attendees)); // 3.200.000
        System.out.println(french.format(attendees)); // 3 200 000

        double money = 1_000_841.56;
        System.out.println(ru.format(money)); // 1 000 841,56
        System.out.println(us.format(money)); // 1,000,841.56
        System.out.println(german.format(money)); // 1.000.841,56
        System.out.println(french.format(money)); // 1 000 841,56

        NumberFormat curRU = NumberFormat.getCurrencyInstance();
        NumberFormat curUS = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat curGE = NumberFormat.getCurrencyInstance(Locale.GERMAN);
        NumberFormat curFR = NumberFormat.getCurrencyInstance(Locale.FRENCH);
        System.out.println(curRU.format(money)); // 1 000 841,56 руб.
        System.out.println(curUS.format(money)); // $1,000,841.56
        System.out.println(curGE.format(money)); // ¤ 1.000.841,56
        System.out.println(curFR.format(money)); // 1 000 841,56 ¤
    }
}
