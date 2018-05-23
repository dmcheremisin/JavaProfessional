package $01AdvancedClassDesign.interfaces;

/**
 * Created by Dmitrii on 22.05.2018.
 */
interface Boiler {
    public void boil();
    public static void shutdown() {
        System.out.println("shutting down");
    }
}
interface Vaporizer extends Boiler {  //1
    public default void vaporize() {
        boil();
        System.out.println("Vaporized!");
    }
    // public static void boil(){} -> we can not override instance method with static
}
public class StaticAccess implements Vaporizer {
    public void boil() {
        System.out.println("Boiling...");
    }

    public static void main(String[] args) {
        Vaporizer v = new StaticAccess(); //2
        v.vaporize(); //3
        // v.shutdown(); //4 -> error shutdown is static and belongs only to the interface
        // Vaporizer.shutdown(); -> error: shutdown belongs to the Boiler class only
        Boiler.shutdown();
    }
}
