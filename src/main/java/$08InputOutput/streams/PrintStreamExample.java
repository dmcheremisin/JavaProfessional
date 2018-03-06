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

    private static void tryFormatAndPrintf() throws FileNotFoundException {
        try(PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(DIR + "zoo3.txt")))){
            ps.format("Today is %s weather", "sunny"); // Today is sunny weather
            ps.println();
            ps.printf("It is raining %s days per year", 123); // It is raining 123 days per year
        }
    }

    private static void tryPrintAndWrite() throws IOException {
        try (PrintStream ps = new PrintStream(DIR + "zoo2.txt")) {
            ps.print(5);
            ps.write(5); // will produce broken symbol []
            //ps.write("5"); method that accepts String has private access only
            ps.println();

            Animal animal = new Animal("Tiger", 5, 'T');
            ps.println(animal);
            ps.write(animal.toString().getBytes());
        }
        // 5
        // Animal[name='Tiger', age=5, type='T']
        // Animal[name='Tiger', age=5, type='T']
    }
}
