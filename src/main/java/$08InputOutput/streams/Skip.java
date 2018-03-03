package $08InputOutput.streams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Dmitrii on 03.03.2018.
 */
public class Skip {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream is =
                     new BufferedInputStream(new FileInputStream(new File("src\\main\\resources\\sample.txt")))) {
            System.out.println((char) is.read());
            is.skip(2);
            System.out.println((char) is.read());
        }
        // A
        // D
    }
}
