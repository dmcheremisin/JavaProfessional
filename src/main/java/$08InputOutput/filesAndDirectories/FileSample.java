package $08InputOutput.filesAndDirectories;

import java.io.File;

/**
 * Created by Dmitrii on 01.03.2018.
 */
public class FileSample {
    public static void main(String[] args) {
        File file = new File("C:\\Workspace\\JavaProfessional\\src\\main\\resources\\sample.txt");
        System.out.println(file.exists());//true
    }
}
