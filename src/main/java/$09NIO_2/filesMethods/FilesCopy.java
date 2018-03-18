package $09NIO_2.filesMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 18.03.2018.
 */
public class FilesCopy {
    public static void main(String[] args) {
        Path path1 = Paths.get("src\\main\\resources\\");
        Path path2 = Paths.get("C:\\main\\resources");
        Path path3 = Paths.get("C:\\resources");
        Path file1 = path1.resolve("sample.txt");
        Path file2 = path3.resolve("sample.txt");
        try {
            // Files.copy(path1, path2);
            // IOException -> Can not copy: C:\main\resources, no main directory
            Files.copy(path1, path3); // copies directory
            Files.copy(file1, file2); // copies file
        } catch (IOException e) {
            System.out.println("Can not copy: " + e.getMessage());
        }

    }
}
