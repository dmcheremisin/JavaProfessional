package $05DatesStringsLocalization.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitrii on 18.11.2018.
 */
public class UrlExtractor {
    public static void main(String[] args) {
        String str = "http://localhost:8082/js?abcd=123";
        Pattern pattern1 = Pattern.compile("^.*/([a-zA-Z0-9\\-]*)(\\?(.*))?$");
        Matcher matcher1 = pattern1.matcher(str);
        if(matcher1.matches()){
            System.out.println(matcher1.group(0));
            System.out.println(matcher1.group(1));
            System.out.println(matcher1.group(2));
            System.out.println(matcher1.group(3));
        }

        //http://localhost:8082/js?abcd=123
        //js
        //?abcd=123
        //abcd=123
    }
}
