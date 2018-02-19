package $05DatesStringsLocalization.i18nAndL10n;

import java.util.Locale;

/**
 * Created by Dmitrii on 19.02.2018.
 */
public class CreateLocale {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale); //ru_RU

        // invalid locale formats: US, enUS, US_en, EN

        System.out.println(Locale.GERMAN); // de
        System.out.println(Locale.GERMANY); // de_DE

        System.out.println(new Locale("fr")); // fr
        System.out.println(new Locale("hi", "IN")); // hi_IN

        Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
        Locale l2 = new Locale.Builder().setRegion("us").setLanguage("EN").build();
        System.out.println(l1 + " " + l2); // en_US en_US

        // set default locale
        Locale.setDefault(l1);
        System.out.println(Locale.getDefault()); // en_US
    }
}
