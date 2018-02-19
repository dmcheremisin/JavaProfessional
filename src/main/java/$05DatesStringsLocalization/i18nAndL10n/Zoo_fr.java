package $05DatesStringsLocalization.i18nAndL10n;

import java.util.ListResourceBundle;

/**
 * Created by Dmitrii on 19.02.2018.
 */
public class Zoo_fr extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][]{
                {"hello", "Bonjour"},
                {"open", "Le zoo est ouvert"},
                {"price", new Double(5.67)}
        };
    }
}
