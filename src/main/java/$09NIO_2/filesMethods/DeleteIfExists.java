package $09NIO_2.filesMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 19.03.2018.
 */
public class DeleteIfExists {
    public static void main(String[] args) {
        Path dir = Paths.get("C:\\files");
        Path inner = dir.resolve("innerFolder");
        Path file = inner.resolve("file.txt");
        try {
            // Files.delete(dir);
            // Files.deleteIfExists(dir);
            // Can't remove: C:\files -> the dir is not empty

            Files.delete(file);
            Files.deleteIfExists(file);
            Files.deleteIfExists(inner);
        } catch (IOException e) {
            System.out.println("Can't remove: " + e.getMessage());
        }
    }
}
