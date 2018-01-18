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
        // first problem
        List list = new ArrayList();
        list.add(new Dragon());
        list.add(new Unicorn());
        //printDragons(list);

        // second problem
        List<Unicorn> unicorns = new ArrayList<>();
        addUnicorns(unicorns);
        Unicorn unicorn = unicorns.get(0); // ClassCastException Dragon to the Unicorn
    }

    private static void printDragons(List<Dragon> list) {
        Dragon dragon1 = list.get(0);// OK for the first dragon
        for (Dragon dragon : list) { // here happens ClassCastException Unicorn to Dragon
            // because we added unicorn to the list
            System.out.println(dragon);
        }

    }

    private static void addUnicorns(List unicorns) {
        unicorns.add(new Dragon());
        Object o = unicorns.get(0);
    }
}
