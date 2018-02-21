package $06ExceptionsAndAssertions.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by Dmitrii on 21.02.2018.
 */
public class TryWithResourcesBasic {
    public static void main(String[] args) {
        // very simple try with resource
        try(Scanner sc = new Scanner(System.in)) {}

        try(
                BufferedReader br = Files.newBufferedReader(new File("C:\notes").toPath());
                BufferedWriter bw = Files.newBufferedWriter(new File("C:\notes").toPath());
        ) {
            // some code
        } catch (IOException e) { // IOException should be handled in this example
            // optional catch block
        } finally {
            // optional finally block
        }

        // resources created in the try() block are valid only in the try scope
        try(Scanner sc = new Scanner(System.in)){
            sc.next();
        } catch (Exception e){
            // sc.nextInt();
        } finally {
            // sc.neextInt();
        }
    }
}
