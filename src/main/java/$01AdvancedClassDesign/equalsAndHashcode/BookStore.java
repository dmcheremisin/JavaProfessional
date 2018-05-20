package $01AdvancedClassDesign.equalsAndHashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitrii on 20.05.2018.
 */
class Book {
    private String isbn;

    public Book(String isbn) {
        this.isbn = isbn;
    }
    public boolean equals(Object o) {
        System.out.println("Equals: " + ((Book) o).isbn);
        return (o instanceof Book && ((Book) o).isbn.equals(this.isbn));
    }     // ... setters and getters }
    @Override
    public int hashCode() {
        System.out.println("Hashcode: " + this.isbn + ": " + super.hashCode());
        return  super.hashCode();
    }
}

public class BookStore {
    public static void main(String[] args) {
        Map<Book, Integer> map = new HashMap<Book, Integer>(){{
            put(new Book("A111"), 10);
            put(new Book("B222"), 20);
            put(new Book("A111"), 30);
        }};

        System.out.println(map.get(new Book("A111")));
        //Hashcode: A111: 1173230247
        //Hashcode: B222: 856419764
        //Hashcode: A111: 621009875
        //Hashcode: A111: 1265094477
        //null
    }
}
/*A Map is nothing but a set of buckets holding key-value pairs. Each bucket corresponds to a unique hashcode. When you store a key-value pair in a Map, the following things happen:

1. Hashcode of the key is computed. This key is used to identify the bucket where the key-value must be stored.
2. The key - value pair is stored in that bucket wrapped in a Map.Entry object.
3. If multiple keys have same hashcode value, all those key-value pairs are stored in the same bucket.

Now, a look up in a Map is a three step process:

1. Hashcode of the key is computed. This code is used to identify the bucket where the key should be looked for.
2. For all the key-value pairs in that bucket, check whether the supplied key is equal to the key in the bucket using equals() method.
3. If a match exists, return the value, otherwise, return null.
*/
