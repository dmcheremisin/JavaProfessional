package $08InputOutput.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 03.03.2018.
 */
public class BufferedReaderWriter {
    private static String DIR = "src\\main\\resources\\";

    public static List<String> readLines(String isFile) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DIR + isFile))){
            // read line by line
            String line;
            while ((line = br.readLine()) !=null){
                lines.add(line);
            }
        } catch (IOException e) {}
        return lines;
    }
    public static void writeLines(String outFile, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DIR + outFile))){
            for(String line : lines){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {}
    }

    public static void copy(String isFile, String outFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(DIR + isFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(DIR + outFile))) {
            // read byte by byte
            int oneByte;
            while ((oneByte = br.read()) != -1) {
                bw.write(oneByte);
                bw.flush();
            }

            // read 1024 bytes, this method will add additional empty bytes if read length is < 1024
            char[] read = new char[1024];
            while (br.read(read) != -1) {
                bw.write(read);
            }

            // read 1024 bytes, write with offset and length
            int length;
            while ((length = br.read(read)) > 0) {
                bw.write(read, 0, length);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        writeLines("sample_buffered.txt", readLines("sample.txt"));
    }
}
