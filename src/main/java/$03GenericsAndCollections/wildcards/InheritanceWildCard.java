package $03GenericsAndCollections.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 24.05.2018.
 */
class Booby{}
class Dooby extends Booby{}
class Tooby extends Dooby{}
public class InheritanceWildCard {
    Booby b = new Booby();
    Tooby t = new Tooby();
    public static void main(String[] args) {
        InheritanceWildCard inheritanceWildCard = new InheritanceWildCard();
        ArrayList<Dooby> list = new ArrayList<>();
        inheritanceWildCard.addData1(list);
        inheritanceWildCard.addData2(list);
    }

    public void addData1(List<? super Dooby> list){
        // list.add(b); doesn't compile
        list.add(t);
    }

    public void addData2(List<? extends Dooby> list){
        // Tooby tooby = list.get(0); doesn't compile
        Booby booby = list.get(0);
        System.out.println(booby);
        // $03GenericsAndCollections.wildcards.Tooby@45ee12a7
    }
}
