package $08InputOutput.console;

import java.io.Console;
import java.util.Locale;

/**
 * Created by Dmitrii on 01.03.2018.
 */
public class SimpleConsole {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println(console);
        if(console != null) {
            String userInput = console.readLine();
            console.writer().println("You entered the following: " + userInput);

            console.writer().println("You are great!");
            console.writer().format("The weather is %s today. It is raining %s days.", "sunny", 123);
            console.writer().println();
            console.writer().printf(new Locale("ru", "RU"), "%s is the capital of the UK", "London");
            console.writer().println();
            console.format("The zoo has %s tigers and %s bears", 2, 3);
            console.printf("The zoo has %s tigers and %s bears", 2, 3);
            console.writer().println();

        }
        // java.io.Console@4aa298b7
        // HEllo
        // You entered the following: HEllo
        // You are great!
        // The weather is sunny today. It is raining 123 days.
        // London is the capital of the UK
        // The zoo has 2 tigers and 3 bears
    }
}
