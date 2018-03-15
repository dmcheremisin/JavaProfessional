package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 15.03.2018.
 */
public class Normalize {
    public static void main(String[] args) {
        Path path1 = Paths.get("E:\\data");
        Path path2 = Paths.get("E:\\sys\\home");

        Path relative = path1.relativize(path2);
        System.out.println(relative); //..\sys\home
        System.out.println(path1.resolve(relative)); //E:\data\..\sys\home

        System.out.println(path1.resolve(relative).normalize());
        //E:\sys\home
    }
}
