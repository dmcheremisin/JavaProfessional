package $09NIO_2.filesMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 15.03.2018.
 */
public class isSameFile {
    public static void main(String[] args) {
        Path path1 = Paths.get("src\\main\\resources\\animal.data");
        Path path2 = Paths.get("src\\main\\java\\..\\resources\\animal.data");
        Path path3 = Paths.get("src\\main\\.\\resources\\animal.data");
        Path strange = Paths.get("some/path");
        try {
            System.out.println("1+2: " + Files.isSameFile(path1, path2));
            System.out.println("1+3: " + Files.isSameFile(path1, path3));
            System.out.println("2+3: " + Files.isSameFile(path2, path3));
            System.out.println("strange+strange: " + Files.isSameFile(strange, strange));
            System.out.println("1+strange: " + Files.isSameFile(path1, strange));
        } catch (IOException e) {
            System.out.println("File doesn't exist: " + e.getMessage());
        }
        //1+2: true
        //1+3: true
        //2+3: true
        //strange+strange: true
        //File doesn't exist: some\path

    }
}
