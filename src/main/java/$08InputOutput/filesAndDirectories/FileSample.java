package $08InputOutput.filesAndDirectories;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 01.03.2018.
 */
public class FileSample {
    public static void main(String[] args) {
        // get current directory -> C:\Workspace\JavaProfessional
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());

        File fileAbsPath = new File("C:\\Workspace\\JavaProfessional\\src\\main\\resources\\sample.txt");
        System.out.println(fileAbsPath.exists()); //true

        File fileRelPath = new File("src\\main\\resources\\sample.txt");
        System.out.println(fileRelPath.exists()); // true
    }
}
