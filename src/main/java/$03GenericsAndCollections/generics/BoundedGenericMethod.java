package $03GenericsAndCollections.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dmitrii on 24.06.2018.
 */
public class BoundedGenericMethod {
    public <E extends CharSequence> Collection<E> getWordsStartingWith(Collection<E> input, char ch) {
        Collection<E> returnValue = new ArrayList<E>();
        int len = input.size();
        for (E e : input) {
            if (e.charAt(0) == ch) returnValue.add(e);
        }
        return returnValue;
    }

    public void checkIt() {
        List<String> a = new ArrayList<>();
        a.add("apple");
        a.add("cherry");
        Set<StringBuffer> b = new HashSet<>();
        b.add(new StringBuffer("pineapple"));
        Collection<String> list = getWordsStartingWith(a, 'a');
        System.out.println(list); // [apple]
        Collection<StringBuffer> set = getWordsStartingWith(b, 'b');
        System.out.println(set); // []
    }

    public static void main(String[] args) {
        new BoundedGenericMethod().checkIt();
    }
}
