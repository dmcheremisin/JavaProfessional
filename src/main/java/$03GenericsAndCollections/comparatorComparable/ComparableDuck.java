package $03GenericsAndCollections.comparatorComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmitrii on 25.01.2018.
 */
public class ComparableDuck implements Comparable<ComparableDuck> {
    private String name;

    public ComparableDuck(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(ComparableDuck o) {
        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        List<ComparableDuck> ducks = new ArrayList<>();
        ducks.add(new ComparableDuck("Yellow duck"));
        ducks.add(new ComparableDuck("Skrudje"));
        ducks.add(new ComparableDuck("Black duck"));
        Collections.sort(ducks);
        System.out.println(ducks);
    }
}
