package $07Concurrency.producerConsumer;

import $07Concurrency.Utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Dmitrii on 09.04.2018.
 */
public class ProducerConsumerUse {

    static BlockingQueue<String> window = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Cooker cooker = new Cooker(window);
        Waiter waiter = new Waiter(window);

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(cooker);
        service.submit(waiter);

        service.submit(() -> {
            while (true) {
                Utils.pause(2000);
                int size = window.size();
                System.out.println("Queue size: " + size);
                if(size >= 2){
                    service.submit(new Waiter(window));
                }
            }
        });
        //New Waiter is comming!
        //Cooker: start cooking dish
        //Waiter: start waiting for a dish
        //Cooker: cooked a dish
        //Cooker: start cooking dish
        //Queue size: 1
        //Cooker: cooked a dish
        //Cooker: start cooking dish
        //Queue size: 2
        //New Waiter is comming!
        //Waiter: start waiting for a dish
        //Cooker: cooked a dish
        //Cooker: start cooking dish
        //Waiter: serving dish
        //Waiter: start waiting for a dish
        //Queue size: 2
        //New Waiter is comming!
        //Waiter: start waiting for a dish
        //Waiter: serving dish
        //Waiter: start waiting for a dish
        //Cooker: cooked a dish
        //Cooker: start cooking dish
        //Queue size: 2
        //New Waiter is comming!
        //Waiter: start waiting for a dish
        //Waiter: serving dish
        //Waiter: start waiting for a dish
        //Waiter: serving dish
        //Waiter: start waiting for a dish
        //Cooker: cooked a dish
        //Cooker: start cooking dish
        //Queue size: 1
        //Waiter: serving dish
        //Waiter: start waiting for a dish
        //Cooker: cooked a dish
        //Cooker: start cooking dish
        //Waiter: serving dish
        //Waiter: start waiting for a dish
        //Queue size: 0
        //Cooker: cooked a dish
        //Cooker: start cooking dish
        //Waiter: serving dish
        //Waiter: start waiting for a dish
        //Queue size: 0

    }
}
