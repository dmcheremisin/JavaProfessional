import java.time.LocalDate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String str = "fdsf1.b23";
        str = str.replaceAll("\\D", "");
        System.out.println(str);

        Stream<LocalDate> s = Stream.of(LocalDate.now());
        UnaryOperator<LocalDate> u = l -> l;
        s.filter(l -> l != null).map(u).peek(System.out::println);
    }
}
