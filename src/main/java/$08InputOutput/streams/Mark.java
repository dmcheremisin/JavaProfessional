package $08InputOutput.streams;

import java.io.*;

/**
 * Created by Dmitrii on 03.03.2018.
 */
public class Mark {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream is =
                     new BufferedInputStream(new FileInputStream(new File("src\\main\\resources\\sample.txt")))) {
            System.out.println((char) is.read());
            System.out.println(is.markSupported());
            if(is.markSupported()){
                is.mark(100);
                System.out.print((char) is.read());
                System.out.println((char) is.read());
                is.reset();
            }
            System.out.print((char) is.read());
            System.out.print((char) is.read());
            System.out.print((char) is.read());
            // A
            // true
            // BC
            // BCD

            // if use only FileInputStream
            // A
            // false
            // BCD


        }
    }
}
