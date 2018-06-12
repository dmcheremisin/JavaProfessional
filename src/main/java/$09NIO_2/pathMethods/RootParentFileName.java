package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 14.03.2018.
 */
public class RootParentFileName {

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
        //File name is: file.name
        //Root is: \
        //Current parent: \root\dir
        //Current parent: \root
        //Current parent: \

        getPathInfo(Paths.get("relativePath/file.name"));
        //File name is: file.name
        //Root is: null
        //Current parent: relativePath
    }
}
