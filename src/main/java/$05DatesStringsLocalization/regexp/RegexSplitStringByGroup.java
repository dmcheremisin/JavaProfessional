package $05DatesStringsLocalization.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSplitStringByGroup {
    public static void main(String[] args) {
        String subjectString= "hello_5_9_2018_world";
        Pattern pattern = Pattern.compile("([a-zA-Z]+)_(.*)_([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(subjectString);
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }

    }
}
