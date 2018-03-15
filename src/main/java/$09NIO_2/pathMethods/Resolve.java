package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 15.03.2018.
 */
public class Resolve {
    public static void main(String[] args) {
        Path path1 = Paths.get("cats/../panther");
        Path path2 = Paths.get("food");
        System.out.println(path1.resolve(path2));
        // cats\..\panther\food

        Path path3 = Paths.get("/turkey/food");
        Path path4 = Paths.get("/turkey/cage");
        System.out.println(path3.resolve(path4));
        // \turkey\cage
    }
}
