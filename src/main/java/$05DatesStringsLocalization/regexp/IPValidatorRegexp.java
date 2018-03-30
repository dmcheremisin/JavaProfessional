package $05DatesStringsLocalization.regexp;

import java.util.regex.Pattern;

/**
 * Created by Dmitrii on 30.03.2018.
 */
public class IPValidatorRegexp {
    public static boolean validateIp(String input){
        String regexp = "\\b((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\b";
        return Pattern.matches(regexp, input);
    }

    public static void main(String[] args) {
        String ip1= "255.245.188.123";
        String ip2= "255.245.188.273";
        System.out.println(validateIp(ip1)); // true
        System.out.println(validateIp(ip2)); // false
    }
}
