package $02DesignPatternsAndPrinciples.singletonPattern;

/**
 * Created by Dmitrii on 13.01.2018.
 */
public class HayStorageLazyLoading {
    private static volatile HayStorageLazyLoading instance;
    private int quantity = 0;
    private HayStorageLazyLoading() {}

    public static HayStorageLazyLoading getInstance() {
        if (instance == null){
            synchronized (HayStorageLazyLoading.class) {
                instance = new HayStorageLazyLoading();
            }
        }
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
