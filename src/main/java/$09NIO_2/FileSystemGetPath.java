package $09NIO_2;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by Dmitrii on 13.03.2018.
 */
public class FileSystemGetPath {
    public static void main(String[] args) throws URISyntaxException {
        Path path = FileSystems.getDefault().getPath("src\\main\\resources\\animal.data");
        System.out.println(path.toFile().exists()); // true

        FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://yandex.ru"));
        Path pathYa = fileSystem.getPath("server.txt");
    }
}
