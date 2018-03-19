package $09NIO_2.filesMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Dmitrii on 19.03.2018.
 */
public class ReadAllLines {
    public static void main(String[] args) {
        Path file = Paths.get("src\\main\\resources\\sample.txt");
        try{
            List<String> lines = Files.readAllLines(file);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
