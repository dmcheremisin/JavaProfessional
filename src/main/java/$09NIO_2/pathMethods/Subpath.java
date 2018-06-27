package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 14.03.2018.
 */
public class Subpath {
    public static void main(String[] args) {
        Path path = Paths.get("/mammal/tiger/sherkhan.jpg");
        System.out.println(path);
        System.out.println("0-3 : " + path.subpath(0,3));
        System.out.println("0-2 : " + path.subpath(0,2));
        System.out.println("1-3 : " + path.subpath(1,3));
        System.out.println("1-2 : " + path.subpath(1,2));
        // System.out.println("2-2 : " + path.subpath(2,2)); IllegalArgumentException
        // System.out.println(path.subpath(1,4)); IllegalArgumentException

        // \mammal\tiger\sherkhan.jpg
        // 0-3 : mammal\tiger\sherkhan.jpg
        // 0-2 : mammal\tiger
        // 1-3 : tiger\sherkhan.jpg
        // 1-2 : tiger

        System.out.println();
        path = Paths.get("c:\\a\\b\\c.java");
        System.out.println("0-3 : " + path.subpath(0,3)); // a\b\c.java
        System.out.println("0-2 : " + path.subpath(0,2)); // a\b
        System.out.println("1-3 : " + path.subpath(1,3)); // b\c.java
        System.out.println("1-2 : " + path.subpath(1,2)); // b

        Path p1 = Paths.get("c:\\a\\b\\c.java");
        System.out.println(p1.getName(0).toString()); // a
        System.out.println(p1.getName(1).toString()); // b
        System.out.println(p1.getName(2).toString()); // c.java
        System.out.println(p1.getName(3).toString()); // c.java
    }
}
