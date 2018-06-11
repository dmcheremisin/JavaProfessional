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
            char[] password = console.readPassword("%s", "Enter your password: ");

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

            console.writer().println();

            String id = console.readLine("%s", "Enter UserId:");
            System.out.println("userid is " + id);
            char[] pwd = console.readPassword("%s", "Enter Password :");
            System.out.println("password is " + new String(pwd));
            // Enter UserId:1
            // userid is 1
            // Enter Password : 123
            // password is 123
        }
    }
}
