package $09NIO_2.filesMethods;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 15.03.2018.
 */
public class FilesExists {
    public static void main(String[] args) {
        String DIR = "src\\main\\resources\\";
        Path dir = Paths.get(DIR);
        System.out.println(Files.exists(dir)); // true
        System.out.println(Files.exists(dir.resolve("animal.data"))); // true
        System.out.println(Files.exists(Paths.get("some/strange/path"))); // false
    }
}
