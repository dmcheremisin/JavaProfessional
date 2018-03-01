package $08InputOutput.filesAndDirectories;

import java.io.File;

/**
 * Created by Dmitrii on 01.03.2018.
 */
public class WorkingWithFiles {
    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\sample.txt");
        System.out.println("File exists: " + file.exists());
        getInfo(file);
        // File exists: true
        //Path: src\main\resources\sample.txt
        //Absolute path: C:\Workspace\JavaProfessional\src\main\resources\sample.txt
        //Is Directory: false
        //Parent path: src\main\resources
        //File size: 0
        //File last modified: 1519890290756

        System.out.println(" ==================================== ");

        File dir = new File("src\\main\\resources\\");
        getInfo(dir);
        // Path: src\main\resources
        //Absolute path: C:\Workspace\JavaProfessional\src\main\resources
        //Is Directory: true
        //Parent path: src\main
        //File in the directory:
        //	src\main\resources\sample.txt
        //	src\main\resources\Zoo.properties
        //	src\main\resources\Zoo_en.properties
        //	src\main\resources\Zoo_fr.properties
    }

    private static void getInfo(File file) {
        if(file.exists()){
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent path: " + file.getParent());
            if(file.isFile()) {
                System.out.println("File size: " + file.length());
                System.out.println("File last modified: " + file.lastModified());
            } else {
                System.out.println("File in the directory: ");
                for (File subFile : file.listFiles()) {
                    System.out.println("\t" + subFile);
                }
            }
        }
    }
}
