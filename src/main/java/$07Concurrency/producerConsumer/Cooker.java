package $07Concurrency.producerConsumer;

import $07Concurrency.Utils;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Dmitrii on 09.04.2018.
 */
public class Cooker implements Runnable {

    private Random random = new Random();
    private BlockingQueue<String> window;

    public Cooker(BlockingQueue<String> window) {
        this.window = window;
    }

    public void run() {
        while (true) {
            System.out.println("Cooker: start cooking dish");
            Utils.pause(1000 + random.nextInt(2000));
            try {
                System.out.println("Cooker: cooked a dish");
                window.put("dish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
