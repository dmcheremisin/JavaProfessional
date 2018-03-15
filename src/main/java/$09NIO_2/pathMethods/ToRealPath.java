package $09NIO_2.pathMethods;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 15.03.2018.
 */
public class ToRealPath {
    public static void main(String[] args) {
        try {
            Path file = Paths.get("src\\main\\resources\\animal.data");
            System.out.println(file.toRealPath());
            // C:\Workspace\JavaProfessional\src\main\resources\animal.data

            Path dir = Paths.get("C:\\Workspace\\");
            System.out.println(dir.toRealPath());
            // C:\Workspace

            Path notExist = Paths.get("some/strange/path.file");
            System.out.println(notExist.toRealPath());
        } catch (IOException e) {
            System.out.println("File doesn't exist: " + e.getMessage());
            // File doesn't exist: C:\Workspace\JavaProfessional\some\strange\path.file
        }
    }
}
