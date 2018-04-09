package $07Concurrency.producerConsumer;

import $07Concurrency.Utils;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Dmitrii on 09.04.2018.
 */
public class Waiter implements Runnable {

    private Random random = new Random();
    private BlockingQueue<String> window;

    public Waiter(BlockingQueue<String> window) {
        System.out.println("New Waiter is comming!");
        this.window = window;
    }

    public void run() {
        while (true) {
            System.out.println("Waiter: start waiting for a dish");
            Utils.pause(2000 + random.nextInt(3000));
            String dish = null;
            try {
                dish = window.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiter: serving " + dish);
        }
    }
}
