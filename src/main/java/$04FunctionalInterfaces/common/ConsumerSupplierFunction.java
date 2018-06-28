package $04FunctionalInterfaces.common;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Dmitrii on 28.06.2018.
 */
public class ConsumerSupplierFunction {
    public static void main(String[] args) {

        String name = "bob";
        Supplier<String> supplier = () -> name.toUpperCase();
        supplier = name::toUpperCase;

        Consumer<String> stringConsumer = s -> s.toUpperCase();
        stringConsumer = String::toUpperCase;

        Function<Locale, String> function = locale -> name.toUpperCase(locale);
        function = name::toUpperCase;
    }
}
