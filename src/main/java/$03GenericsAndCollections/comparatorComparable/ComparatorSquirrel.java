package $03GenericsAndCollections.comparatorComparable;

import java.util.*;

/**
 * Created by Dmitrii on 26.01.2018.
 */
public class ComparatorSquirrel {
    public String name;
    public int weight;

    public ComparatorSquirrel(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" + name + ", weight=" + weight + "}\r\n";
    }

    public static void main(String[] args) {
        List<ComparatorSquirrel> list = new ArrayList<>();
        list.add(new ComparatorSquirrel("red", 10));
        list.add(new ComparatorSquirrel("brown", 30));
        list.add(new ComparatorSquirrel("yellow", 20));
        Collections.sort(list, Comparator.comparingInt(s -> s.weight));
        System.out.println(list);
        Collections.sort(list, (s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println(list);
    }
}
