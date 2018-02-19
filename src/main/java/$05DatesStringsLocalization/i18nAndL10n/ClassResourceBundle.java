package $05DatesStringsLocalization.i18nAndL10n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Dmitrii on 19.02.2018.
 */
public class ClassResourceBundle {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("$05DatesStringsLocalization.i18nAndL10n.Zoo", Locale.FRENCH);
        System.out.println(rb.getObject("hello"));
        System.out.println(rb.getObject("open"));
        System.out.println((Double) rb.getObject("price"));
    }
}
