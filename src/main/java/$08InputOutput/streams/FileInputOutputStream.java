package $08InputOutput.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Dmitrii on 03.03.2018.
 */
public class FileInputOutputStream {
    private static String DIR = "src\\main\\resources\\";
    private static String COPY = "_copy";
    private static String EXT = ".txt";


    public static void copy(String file) {
        String isFile = DIR + file + EXT;
        String outFile = DIR + file + COPY + EXT;
        try(FileInputStream is = new FileInputStream(isFile);
            FileOutputStream os = new FileOutputStream(outFile)){
            // read 1024 bytes
            byte[] read = new byte[1024];
            while(is.read(read) != -1){
                os.write(read);
            }
            //      read byte by byte
            int oneByte;
            while((oneByte = is.read()) != -1){
                os.write(oneByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copy("sample");
    }
}
