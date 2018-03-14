package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 14.03.2018.
 */
public class AccessingPath {

    public static void getPathInfo(Path path){
        System.out.println("File name is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());

        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null){
            System.out.println("Current parent: " + currentParent);
        }
    }

    public static void main(String[] args) {
        getPathInfo(Paths.get("/root/dir/file.name"));
        getPathInfo(Paths.get("relativePath/file.name"));
    }
}
