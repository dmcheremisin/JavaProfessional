package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 14.03.2018.
 */
public class NewPathWithSubpath {
    public static void main(String[] args) {
        Path path = Paths.get("/mammal/tiger/sherkhan.jpg");
        System.out.println(path);
        System.out.println("0-3 : " + path.subpath(0,3));
        System.out.println("0-2 : " + path.subpath(0,2));
        System.out.println("1-3 : " + path.subpath(1,3));
        System.out.println("1-2 : " + path.subpath(1,2));
        // System.out.println(path.subpath(1,4)); IllegalArgumentException
        // \mammal\tiger\sherkhan.jpg
        // 0-3 : mammal\tiger\sherkhan.jpg
        // 0-2 : mammal\tiger
        // 1-3 : tiger\sherkhan.jpg
        // 1-2 : tiger
    }
}
