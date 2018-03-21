package $09NIO_2.streamMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Created by Dmitrii on 21.03.2018.
 */
public class Find {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src\\main\\resources\\");
        Path file = path.resolve("sample.txt");
        BasicFileAttributes data = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime sampleTime = data.creationTime();

        Files.find(path, 10, (p,a) -> p.toString().contains("txt") && a.creationTime().equals(sampleTime))
                .forEach(System.out::println);
        // src\main\resources\sample.txt

    }
}
