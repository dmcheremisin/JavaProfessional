package $04FunctionalInterfaces.common;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Dmitrii on 10.02.2018.
 */
class ExceptionCase {
    public static List<String> create() throws IOException {
        throw new IOException();
    }
}
public class StreamsAndExceptions {
    public static void main(String[] args) {
        try {
            ExceptionCase.create().stream().count();
            List<String> strings = ExceptionCase.create();
        } catch (IOException e) {}

        try {
            // Supplier<List<String>> create = ExceptionCase::create; DOESN'T compile
            // Supplier<List<String>> create =() -> ExceptionCase.create(); DOESN'T compile
        } catch (Exception e) {}

        // first approach - catch the exception and turn it into an unchecked exception
        Supplier<List<String>> s = () -> {
          try {
              return ExceptionCase.create();
          } catch (Exception e) {
              throw new RuntimeException();
          }};

        // second approach - create a wrapper method with the try/catch:
        List<String> strings = createSafe();
    }
    public static List<String> createSafe(){
        try {
            return ExceptionCase.create();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
