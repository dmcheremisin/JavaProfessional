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
            // read 1024 bytes, this method will add additional empty bytes if read length is < 1024
            byte[] read = new byte[1024];
            while(is.read(read) != -1){
                os.write(read);
            }
            // read 1024 bytes, write with offset and length
            int length;
            while((length = is.read(read)) > 0) {
                os.write(read, 0, length);
                os.flush();
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
