package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 14.03.2018.
 */
public class isAbsoluteToAbsolute {
    public static void main(String[] args) {
        Path path1 = Paths.get("C:\\birds\\eagle.jpg");
        System.out.println("Is absolute: " + path1.isAbsolute());
        System.out.println("To absolute: " + path1.toAbsolutePath());
        // Is absolute: true
        // To absolute: C:\birds\eagle.jpg

        Path path2 = Paths.get("animals/birds/eagle.jpg");
        System.out.println("Is absolute: " + path2.isAbsolute());
        System.out.println("To absolute: " + path2.toAbsolutePath());
        // Is absolute: false
        // To absolute: C:\Workspace\JavaProfessional\animals\birds\eagle.jpg
    }
}
