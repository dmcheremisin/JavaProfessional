package $03GenericsAndCollections.generics;

/**
 * Created by Dmitrii on 24.05.2018.
 */
public class PlaceHolder<K, V> {
    private K k;
    private V v;
    public PlaceHolder(K k, V v) {
        this.k = k;
        this.v = v;
    }
    public K getK() {
        return k;
    }
    public static <X> PlaceHolder<X, X> getDuplicateHolder(X x) {
        return new PlaceHolder<X, X>(x, x);
    }

    public static void main(String[] args) {
        PlaceHolder<String, String> placeHolder = getDuplicateHolder("one");
        System.out.println(placeHolder.getK()); // one
    }
}
