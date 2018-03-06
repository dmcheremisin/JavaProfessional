package $08InputOutput.streams;

import java.io.*;

/**
 * Created by Dmitrii on 06.03.2018.
 */
public class PrintStreamExample {
    private static String DIR = "src\\main\\resources\\";
    public static void main(String[] args) throws IOException {
        tryPrintAndWrite();
        tryFormatAndPrintf();
    }

    private static void tryFormatAndPrintf() throws IOException {
        try(PrintStream pw = new PrintStream(new BufferedOutputStream(new FileOutputStream(DIR + "zoo3.txt")))){
            pw.format("Today is %s weather", "sunny"); // Today is sunny weather
            pw.println();
            pw.printf("It is raining %s days per year", 123); // It is raining 123 days per year
        }
    }

    private static void tryPrintAndWrite() throws IOException {
        try (PrintStream pw = new PrintStream(DIR + "zoo2.txt")) {
            pw.print(5);
            pw.write(5); // accepts only Strings, will produce broken symbol []
            //pw.write("5"); accepts int or byte array
            pw.println();

            Animal animal = new Animal("Tiger", 5, 'T');
            pw.println(animal);
            pw.write(animal.toString().getBytes());
        }
        // 5
        // Animal[name='Tiger', age=5, type='T']
        // Animal[name='Tiger', age=5, type='T']
    }
}
