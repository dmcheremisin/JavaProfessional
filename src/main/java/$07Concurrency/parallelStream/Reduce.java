package $07Concurrency.parallelStream;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static String result = "";
    public static void concat(String str){
        result = result + " " + str;
    }

    public static void main(String[] args) {
        String[] strings = "the quick brown fox jumps over the lazy dog".split(" ");
        Arrays.stream(strings).forEach(Reduce::concat);
        System.out.println(result); //  the quick brown fox jumps over the lazy dog
        result = "";
        Arrays.stream(strings).parallel().forEach(Reduce::concat);
        System.out.println(result); //  over jumps lazy dog the brown fox quick the

        Optional<String> reduce = Arrays.stream(strings).parallel().reduce((s1, s2) -> s1 + " " + s2);
        System.out.println(reduce.get()); // the quick brown fox jumps over the lazy dog


        List<? extends Serializable> chars = Arrays.asList('w', 'o', 'l', "f");

        String sequential = chars.stream().reduce("", (c, s1) -> c + s1, (s1, s2) -> s1 + s2);
        System.out.println(sequential); // wolf

        String parallel = chars.parallelStream().reduce("", (c, s1) -> c + s1, (s1, s2) -> s1 + s2);
        System.out.println(parallel); //wolf
    }
}
