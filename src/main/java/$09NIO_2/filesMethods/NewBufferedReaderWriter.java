package $09NIO_2.filesMethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitrii on 19.03.2018.
 */
public class NewBufferedReaderWriter {
    public static void main(String[] args) {
        Path dir = Paths.get("src\\main\\resources\\");
        Path source = dir.resolve("sample.txt");
        Path target = dir.resolve("target.txt");
        try(BufferedReader br = Files.newBufferedReader(source, Charset.defaultCharset());
            BufferedWriter bw = Files.newBufferedWriter(target)) {
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
