package $09NIO_2;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 11.03.2018.
 */
public class CreatingPaths {
    private static String DIR = "src\\main\\resources\\";
    public static void main(String[] args) throws URISyntaxException {
        Path pathDir = Paths.get(DIR);
        System.out.println(pathDir); // src\main\resources

        Path pathFile = Paths.get(DIR + "zoo.txt");
        System.out.println(pathFile.toFile().exists()); // true

        Path pathAbs = Paths.get("C:\\Workspace\\JavaProfessional\\" + DIR + "zoo.txt");
        System.out.println(pathAbs.toFile().exists()); // true

        Path pathVararg = Paths.get("src", "main", "resources", "zoo.txt");
        System.out.println(pathVararg.toFile().exists()); // true

        Path pathRelativeURI = Paths.get(new URI("file:///src/main/resources/zoo.txt"));
        System.out.println(pathRelativeURI.toFile().exists()); // false

        Path pathURI = Paths.get(new URI("file:///C:/Workspace/JavaProfessional/src/main/resources/zoo.txt"));
        System.out.println(pathURI.toFile().exists()); // true

        System.out.println(pathURI.toUri()); // file:///C:/Workspace/JavaProfessional/src/main/resources/zoo.txt
    }
}
