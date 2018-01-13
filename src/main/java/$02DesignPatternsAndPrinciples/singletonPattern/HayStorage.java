package $02DesignPatternsAndPrinciples.singletonPattern;

/**
 * Created by Dmitrii on 13.01.2018.
 */
public class HayStorage {
    private static final HayStorage instance;
    static {
        instance = new HayStorage();
        System.out.println("HayStorage is created");
    }

    private int quantity = 0;
    private HayStorage() {}

    public static HayStorage getInstance() {
        System.out.println("Get HayStrorage");
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (amount > quantity) {
            return false;
        }
        quantity -= amount;
        return true;
    }
    public synchronized int getHayQuantity() {
        return quantity;
    }

    public static void main(String[] args) {
        getInstance();
        getInstance();
        getInstance();
    }
}
