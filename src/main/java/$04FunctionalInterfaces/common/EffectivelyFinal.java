package $04FunctionalInterfaces.common;

/**
 * Created by Dmitrii on 04.02.2018.
 */
interface Gorilla{
    String move();
}
class GorillaImpl {
    String walk = "walk";
    void everyOnePlay(boolean baby) {
        String approach = "amble";
        // approach = "run"; -> variable is not effectively final
        // baby = false; variable is not effectively final
        walk = "fast walk";
        play(() -> approach);
        play(() -> baby ? "ride" : "run");
        play(() -> walk);
    }
    void play(Gorilla g) {
        System.out.println(g.move());
    }
}
public class EffectivelyFinal {
    public static void main(String[] args) {
        GorillaImpl gorilla = new GorillaImpl();
        gorilla.everyOnePlay(true);
//        amble
//        ride
//        fast walk
    }
}
