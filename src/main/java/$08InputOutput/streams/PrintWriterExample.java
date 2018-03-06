package $08InputOutput.streams;

import java.io.*;

/**
 * Created by Dmitrii on 06.03.2018.
 */
public class PrintWriterExample {
    private static String DIR = "src\\main\\resources\\";
    public static void main(String[] args) throws IOException {
        tryPrintAndWrite();
        tryFormatAndPrintf();
    }

    private static void tryFormatAndPrintf() throws IOException {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(DIR + "zoo1.txt")))){
            pw.format("Today is %s weather", "sunny"); // Today is sunny weather
            pw.println();
            pw.printf("It is raining %s days per year", 123); // It is raining 123 days per year
        }
    }

    private static void tryPrintAndWrite() throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(DIR + "zoo.txt")) {
            pw.print(5);
            pw.write(5); // accepts only Strings, will produce broken symbol []
            pw.write(String.valueOf(5));
            pw.println();

            Animal animal = new Animal("Tiger", 5, 'T');
            pw.println(animal);
            pw.write(animal.toString());
        }
        // 55
        // Animal[name='Tiger', age=5, type='T']
        // Animal[name='Tiger', age=5, type='T']
    }
}
