package $05DatesStringsLocalization.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitrii on 30.03.2018.
 */
public class DigitsRegexp {
    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, " +
                "Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post" +
                "office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        // we want to extract ZIP codes of length 5
        Pattern pattern = Pattern.compile("\\d{5}");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.print(matcher.group() + " ");
        }
        // 56010 98765 43210 56000 98765 01234
        // so we extracted phones also

        System.out.println();
        pattern = Pattern.compile("\\D\\d{5}\\D");
        matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        //  56010,
        //  56000,
        // received additional space and ","

        System.out.println();
        pattern = Pattern.compile("\\b\\d{5}\\b");
        matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        //56010
        //56000
        // received exactly what we wanted
    }
}
