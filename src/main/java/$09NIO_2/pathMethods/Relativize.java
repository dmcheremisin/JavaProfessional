package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 14.03.2018.
 */
public class Relativize {
    public static void main(String[] args) {
        Path path1 = Paths.get("E:\\habitat");
        Path path2 = Paths.get("E:\\sanctuary\\raven");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
        // ..\sanctuary\raven
        // ..\..\habitat

        Path path3 = Paths.get("fish.txt");
        Path path4 = Paths.get("bird.txt");
        System.out.println(path3.relativize(path4));
        System.out.println(path4.relativize(path3));
        // ..\bird.txt
        // ..\fish.txt

        // we can't mix relative and absolute paths
        Path path5 = Paths.get("/primate/ape.txt");
        Path path6 = Paths.get("banana.txt");
        // path5.relativize(path6); -> IllegalArgumentException

        // we can't relativize on different drive letters for Windows
        Path path7 = Paths.get("C:\\ape.txt");
        Path path8 = Paths.get("E:\\banana.txt");
        // path7.relativize(path8); -> IllegalArgumentException
    }
}
