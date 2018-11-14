package $08InputOutput.streams;

import java.io.*;

/**
 * Created by Dmitrii on 04.03.2018.
 */
public class ReadAllBytes {
    private static String DIR = "src\\main\\resources\\";

    public static void main(String[] args) throws IOException {
        try {
            byte[] fileAsBytes = getArrayFromInputStream(new FileInputStream(new File(DIR + "pdf-sample.pdf")));
            writeContent(fileAsBytes, DIR + "pdf_sample2.pdf");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static byte[] getArrayFromInputStream(InputStream inputStream) throws IOException {
        byte[] bytes;
        byte[] buffer = new byte[1024];
        try(BufferedInputStream is = new BufferedInputStream(inputStream)){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int length;
            while ((length = is.read(buffer)) > -1 ) {
                bos.write(buffer, 0, length);
            }
            bos.flush();
            bytes = bos.toByteArray();
        }
        return bytes;
    }

    private static void writeContent(byte[] content, String fileToWriteTo) throws IOException {
        File file = new File(fileToWriteTo);
        try(BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(file))){
            salida.write(content);
            salida.flush();
        }
    }
}
