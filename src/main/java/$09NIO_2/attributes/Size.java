package $09NIO_2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 19.03.2018.
 */
public class Size {
    public static void main(String[] args) {
        Path file = Paths.get("src\\main\\resources\\sample.txt");
        try {
            System.out.println(Files.size(file));
        } catch (IOException e) { }
    }
}
