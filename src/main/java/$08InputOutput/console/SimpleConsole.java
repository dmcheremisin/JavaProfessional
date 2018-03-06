package $08InputOutput.console;

import java.io.Console;

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
        }
    }
}
