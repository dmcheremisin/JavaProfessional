package $09NIO_2.attributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 19.03.2018.
 */
public class isFileDirectorySymbolicLink {
    public static void main(String[] args) {
        Path resources = Paths.get("src\\main\\resources\\");
        Path file = resources.resolve("sample.txt");
        Path link = Paths.get("C:\\files\\linkToFile");

        System.out.println(Files.isDirectory(resources));// true
        System.out.println(Files.isRegularFile(file));// true
        System.out.println(Files.isSymbolicLink(link));// true
        System.out.println(Files.isRegularFile(link));// true

    }
}
