package $09NIO_2.streamMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 21.03.2018.
 */
public class Lines {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("src\\main\\resources\\sample.txt");
        Files.lines(file)
                .filter(line -> line.contains("K"))
                .map(line  -> "Line: " + line)
                .forEach(System.out::println);
        // Line: IJKL
    }
}
