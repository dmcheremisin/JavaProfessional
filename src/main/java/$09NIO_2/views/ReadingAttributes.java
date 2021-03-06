package $09NIO_2.views;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Dmitrii on 21.03.2018.
 */
public class ReadingAttributes {
    public static void main(String[] args) {
        Path file = Paths.get("src\\main\\resources\\sample.txt");
        try {
            BasicFileAttributes data = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("Is directory: " + data.isDirectory());
            System.out.println("Is file: " + data.isRegularFile());
            System.out.println("Is link: " + data.isSymbolicLink());
            System.out.println("Is other: " + data.isOther());
            System.out.println("Size: " + data.size());
            System.out.println("Creation date/time: " + data.creationTime());
            System.out.println("Modified date/time: " + data.lastModifiedTime());
            System.out.println("Access date/time: " + data.lastAccessTime());
            System.out.println("File key: " + data.fileKey());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Is directory: false
        //Is file: true
        //Is link: false
        //Is other: false
        //Size: 38
        //Creation date/time: 2018-03-01T07:44:50.756065Z
        //Modified date/time: 2018-03-20T11:21:05.674Z
        //Access date/time: 2018-03-05T12:11:27.938543Z
        //File key: null
    }
}
