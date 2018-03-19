package $09NIO_2.attributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author dmch0916
 * Date: 19.03.2018
 * Time: 20:29
 */
public class isReadableExecutable {
    public static void main(String[] args) {
        Path res = Paths.get("src\\main\\resources\\");
        Path sample = res.resolve("sample.txt");
        Path executable = res.resolve("executable.bat");
        System.out.println(Files.isReadable(sample)); // true
        System.out.println(Files.isReadable(executable)); // true
        System.out.println(Files.isExecutable(sample)); // true
        System.out.println(Files.isExecutable(executable)); // true
    }

}
