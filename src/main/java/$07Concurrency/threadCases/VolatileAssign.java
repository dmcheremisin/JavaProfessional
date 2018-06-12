package $07Concurrency.threadCases;

/**
 * Created by Dmitrii on 12.06.2018.
 */
public class VolatileAssign implements Runnable {
    volatile int x;

    public void run() {
        x = 5;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileAssign tc = new VolatileAssign();
        tc.x = 10;
        Thread thread = new Thread(tc);
        thread.start();
        thread.join();
        System.out.println(tc.x); // 5

        tc.x = 10;
        new Thread(tc).start();
        System.out.println(tc.x); // 10
    }
}
