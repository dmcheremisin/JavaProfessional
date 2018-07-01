package $03GenericsAndCollections.generics;

/**
 * Created by Dmitrii on 01.07.2018.
 */
import java.util.*;

class Book { }
class BookList extends ArrayList<Book> {
    public int count = 0;

//    public boolean add(Object o) { Exception -> add(Object) in BookList and add(E) in ArrayList have the same erasure
//        return super.add((Book) o);
//    }
}

public class TypeErasure {
}
