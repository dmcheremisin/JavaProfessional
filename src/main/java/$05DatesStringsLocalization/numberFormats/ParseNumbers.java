package $05DatesStringsLocalization.numberFormats;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Dmitrii on 20.02.2018.
 */
public class ParseNumbers {
    public static void main(String[] args) throws ParseException {
        NumberFormat numUS = NumberFormat.getInstance(Locale.US);
        NumberFormat numFR = NumberFormat.getInstance(Locale.FRENCH);

        String number = "1,000,841.56";
        System.out.println(numUS.parse(number));
        System.out.println(numFR.parse(number));

        String numText = "456asdfsd";
        System.out.println(numFR.parse(numText)); // 456

        String negative = "-231.34x10";
        System.out.println(numUS.parse(negative)); // -231.34

        NumberFormat curRU = NumberFormat.getCurrencyInstance();
        NumberFormat curUS = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat curGE = NumberFormat.getCurrencyInstance(Locale.GERMAN);

        String currencyUS = "$1,000,841.56";
        Number usNum = curUS.parse(currencyUS);
        System.out.println((Double) usNum);
        // System.out.println(curGE.parse(currencyUS)); throws ParseException

        String currencyRub = "1 000 841,56 руб.";
        System.out.println(curRU.parse(currencyRub));
        // System.out.println(curUS.parse(currencyRub)); throws ParseException
    }
}
