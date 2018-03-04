package $08InputOutput.streams;

import java.io.*;

/**
 * Created by Dmitrii on 04.03.2018.
 */
public class BufferedInputOutputStream {
    private static String DIR = "src\\main\\resources\\";

    public static void copy(String isFile, String outFile) {
        try(BufferedInputStream is = new BufferedInputStream(new FileInputStream(DIR + isFile));
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(DIR + outFile))){
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
        copy("sample.txt", "sample_copy.txt");
    }
}
