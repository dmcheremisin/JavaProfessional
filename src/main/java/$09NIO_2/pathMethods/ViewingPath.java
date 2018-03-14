package $09NIO_2.pathMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 14.03.2018.
 */
public class ViewingPath {
    public static void main(String[] args) {
        Path path = Paths.get("some/root/directory/file.name");
        System.out.println("The path is: " + path.toString());
        for(int i = 0; i < path.getNameCount(); i++){
            System.out.println(path.getName(i).toString());
        }
        // The path is: some\root\directory\file.name
        // some
        // root
        // directory
        // file.name
    }
}
