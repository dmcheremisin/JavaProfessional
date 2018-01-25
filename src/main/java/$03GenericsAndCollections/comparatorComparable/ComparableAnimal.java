package $03GenericsAndCollections.comparatorComparable;

/**
 * Created by Dmitrii on 25.01.2018.
 */
public class ComparableAnimal implements Comparable<ComparableAnimal> {
    private int id;

    public ComparableAnimal(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(ComparableAnimal o) {
        return id - o.id;
    }

    public static void main(String[] args) {
        ComparableAnimal a5 = new ComparableAnimal(5);
        ComparableAnimal a7 = new ComparableAnimal(7);
        System.out.println(a5.compareTo(a7));
        System.out.println(a5.compareTo(a5));
        System.out.println(a7.compareTo(a5));
    }
}
