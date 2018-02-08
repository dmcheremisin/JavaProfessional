package $04FunctionalInterfaces.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitrii on 07.02.2018.
 */
public class Peek {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("bear", "tiger", "panda");
        long count1
                = animals.stream().filter(s -> s.startsWith("t"))
                .peek(System.out::println) // tiger
                .count();
        System.out.println(count1); // 1

        StringBuilder sb = new StringBuilder();
        long count2 = animals.stream().peek(a -> sb.append(" " + a)).count();// 3
        System.out.println(sb);// bear tiger panda
    }
}
