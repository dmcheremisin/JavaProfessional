package $09NIO_2.filesMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 18.03.2018.
 */
public class CreateDirectories {
    public static void main(String[] args) {
        try {
            // Files.createDirectory(Paths.get("C:\\pictures\\forest"));
            // Directory doesn't exist: C:\pictures\forest

            Files.createDirectory(Paths.get("C:\\pictures")); // creates picture dir
            Files.createDirectories(Paths.get("C:\\pictures\\forest\\wolf")); // creates forest\wolf dir

        } catch (IOException e) {
            System.out.println("Directory doesn't exist: " + e.getMessage());
        }
    }
}
