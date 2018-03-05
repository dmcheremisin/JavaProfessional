package $08InputOutput.streams;

import java.io.*;

/**
 * Created by Dmitrii on 03.03.2018.
 */
public class FileReaderWriter {
    private static String DIR = "src\\main\\resources\\";

    public static void copy(String isFile, String outFile) {
        try (FileReader fr = new FileReader(DIR + isFile);
             FileWriter fw = new FileWriter(DIR + outFile)) {
            //      read byte by byte
            int oneByte;
            while ((oneByte = fr.read()) != -1) {
                fw.write(oneByte);
                fw.flush();
            }

            // read 1024 bytes, this method will add additional empty bytes if read length is < 1024
            char[] read = new char[1024];
            while (fr.read(read) != -1) {
                fw.write(read);
            }

            // read 1024 bytes, write with offset and length
            int length;
            while ((length = fr.read(read)) > 0) {
                fw.write(read, 0, length);
                fw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        copy("sample.txt", "sample_copy.txt");
    }
}
