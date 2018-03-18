package $09NIO_2.filesMethods;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 18.03.2018.
 */
public class CopyWithStream {
    public static void main(String[] args) {
        String source = "src\\main\\resources\\";
        String sample = source + "sample.txt";
        String target1 = source + "sample1.txt";
        String target2 = source + "sample2.txt";
        try(InputStream is = new FileInputStream(sample);
            OutputStream out = new FileOutputStream(target1)) {

            Files.copy(is, Paths.get(target2));
            Files.copy(Paths.get(sample), out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
