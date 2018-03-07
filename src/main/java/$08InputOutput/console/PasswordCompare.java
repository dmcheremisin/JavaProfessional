package $08InputOutput.console;

import java.io.Console;
import java.util.Arrays;

/**
 * Created by Dmitrii on 07.03.2018.
 */
public class PasswordCompare {
    public static void main(String[] args) {
        Console console = System.console();
        if(console != null){
            char[] password = console.readPassword("Enter your password: ");

            console.format("Enter your password again: ");
            console.flush();
            char[] verify = console.readPassword();
            boolean match = Arrays.equals(password, verify);

            // erases password for security reasons
            Arrays.fill(password,'x');
            Arrays.fill(verify,'x');

            console.format("Your result is : " + (match ? "correct" : "incorrect"));

            // Enter your password:
            // Enter your password again:
            // Your result is : correct
        }
    }
}
