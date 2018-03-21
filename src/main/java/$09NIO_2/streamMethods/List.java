package $09NIO_2.streamMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 21.03.2018.
 */
public class List {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src\\main\\");
        Files.list(path)
                .filter(p -> Files.isDirectory(p))
                .map(p -> p.toAbsolutePath())
                .forEach(System.out::println);
        // C:\Workspace\JavaProfessional\src\main\java
        // C:\Workspace\JavaProfessional\src\main\resources
    }
}
