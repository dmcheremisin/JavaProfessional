package $03GenericsAndCollections.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 17.01.2018.
 */
class Unicorn{}
class Dragon{}
public class LegacyError {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Unicorn());
        list.add(new Dragon());
        printDragons(list);
    }
    private static void printDragons(List<Dragon> list) {
        for (Dragon dragon : list) { // here happens ClassCastException Unicorn to Dragon
            // because we added unicorn to the list
            System.out.println(dragon);
        }

    }
}
