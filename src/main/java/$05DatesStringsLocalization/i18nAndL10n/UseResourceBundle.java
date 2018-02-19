package $05DatesStringsLocalization.i18nAndL10n;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Dmitrii on 19.02.2018.
 */
public class UseResourceBundle {
    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale fr = new Locale("fr", "FR");
        printProperties(null);
        printProperties(us);
        // Hello
        // The zoo is open
        // The zoo is open
        // The zoo is closed
        printProperties(fr);
    }

    private static void printProperties(Locale locale) {
        ResourceBundle bundle;
        if (locale != null){
            bundle = ResourceBundle.getBundle("Zoo", locale);
        } else {
            bundle = ResourceBundle.getBundle("Zoo");
        }
        bundle.keySet().forEach(k -> System.out.println(bundle.getString(k)));

        // properties class is able to return a default value if it is specified
        Properties props = new Properties();
        bundle.keySet().stream().forEach(k -> props.setProperty(k, bundle.getString(k)));
        System.out.println(props.getProperty("open"));
        System.out.println(props.getProperty("closed", "The zoo is closed")); // The zoo is closed
    }
}
