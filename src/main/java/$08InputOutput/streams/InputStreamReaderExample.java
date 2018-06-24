package $08InputOutput.streams;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Dmitrii on 03.03.2018.
 */
public class InputStreamReaderExample {
    private static String DIR = "src\\main\\resources\\";

    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream(DIR+"sample.txt");
             InputStreamReader isr = new InputStreamReader(fis)) {
            while (isr.ready()) { // checks if there are more bytes available to read
                isr.skip(1); // skips the given number of characters i.e. it basically moves the file pointer one character ahead
                int i = isr.read(); // reads one character
                char c = (char) i;
                System.out.print(c);
            }
            //BD
            //FH
            //JL
            //NP
            //RT
            //VX
            //Z
        }
    }
}
