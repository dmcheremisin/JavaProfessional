package $09NIO_2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

/**
 * Created by Dmitrii on 20.03.2018.
 */
public class GetSetLastModifiedTime {
    public static void main(String[] args) {
        Path file = Paths.get("src\\main\\resources\\sample.txt");
        try {
            FileTime fileTime = Files.getLastModifiedTime(file);
            System.out.println(fileTime); // 2018-03-05T12:11:27.938543Z
            System.out.println(fileTime.toMillis()); // 1521544687142
            Files.setLastModifiedTime(file, FileTime.fromMillis(System.currentTimeMillis()));
            System.out.println(Files.getLastModifiedTime(file)); // 2018-03-20T11:18:07.142Z
        } catch (IOException e) {
        }

    }
}
