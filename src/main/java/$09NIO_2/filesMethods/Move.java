package $09NIO_2.filesMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 18.03.2018.
 */
public class Move {
    public static void main(String[] args) {
        // entire structure C:\pictures\innerFolder -> is empty
        // entire structure C:\pictures\file.txt

        Path dir = Paths.get("C:\\pictures");
        Path newDir = Paths.get("C:\\files");
        Path file = Paths.get("file.txt");

        try {
            Files.move(dir, newDir);
            Files.move(newDir.resolve(file), newDir.resolve("innerFolder").resolve(file));
        } catch (IOException e) {
            System.out.println("Can not move: " + e.getMessage());
        }
        // result: C:\files\innerFolder\file.txt
    }
}
