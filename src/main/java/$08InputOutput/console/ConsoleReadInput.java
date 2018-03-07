package $08InputOutput.console;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;

/**
 * Created by Dmitrii on 07.03.2018.
 */
public class ConsoleReadInput {
    public static void main(String[] args) throws IOException {
        Console console = System.console();
        System.out.println(console);
        if(console != null) {
            console.writer().println("How excited are you about your trip?");
            console.flush();
            String excitement = console.readLine();

            String name = console.readLine("Enter your name: ");

            console.writer().print("What is your age?");
            console.flush();
            BufferedReader br = new BufferedReader(console.reader());
            String value = br.readLine();
            Integer age = Integer.parseInt(value);
            console.writer().println();

            console.format("Your name is %s", name);
            console.writer().println();
            console.format("Your age is %s", age);
            console.writer().println();
            console.printf("Your excitement level is : %s", excitement);


        }
    }
}
