package $05DatesStringsLocalization.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFileExtension {
    public static void main(String[] args) {
        String image = "2018-05-16 17_13_27-Greenshot.png";
        Pattern pattern = Pattern.compile("(.+)\\.([A-Za-z]+)");
        Matcher matcher = pattern.matcher(image);
        if(matcher.matches()) {
            System.out.println(matcher.group(2)); // png
        }
    }
}
