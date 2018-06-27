package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 27.06.2018.
 */
public class GetName {
    public static void main(String[] args) {
        Path p1 = Paths.get("c:\\a\\b\\c.java");
        System.out.println(p1.getName(0).toString()); // a
        System.out.println(p1.getName(1).toString()); // b
        System.out.println(p1.getName(2).toString()); // c.java
    }
}
