package $09NIO_2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 19.03.2018.
 */
public class isFileDirectorySymbolicLinkHidden {
    public static void main(String[] args) {
        Path res = Paths.get("src\\main\\resources\\");
        Path file = res.resolve("sample.txt");
        Path link = Paths.get("C:\\files\\linkToFile");

        System.out.println(Files.isDirectory(res));// true
        System.out.println(Files.isRegularFile(file));// true
        System.out.println(Files.isSymbolicLink(link));// true
        System.out.println(Files.isRegularFile(link));// true
        try {
            System.out.println(Files.isHidden(file)); // true
            System.out.println(Files.isHidden(res.resolve("sample_copy.txt"))); // false
        } catch (IOException e) { }

    }
}
