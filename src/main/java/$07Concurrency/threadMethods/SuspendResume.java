package $07Concurrency.threadMethods;

import $07Concurrency.Utils;

/**
 * Created by Dmitrii on 08.04.2018.
 */
public class SuspendResume {

    public static void main(String[] args) {

        System.out.println("Main started");

        Object lock = new Object();

        Thread thread = new Thread(() -> {
            System.out.println("Thream started");
            synchronized (lock) {
                Utils.pause(4000);
                System.out.println("Woke up");
            }
        });
        thread.start();

        Utils.pause(3000);
        thread.suspend();
        System.out.println("Thread is suspended");

        Utils.pause(3000);
        thread.resume();
        System.out.println("Thread is resumed");

        System.out.println("Main finished");
        // Main started
        //Thream started
        //Thread is suspended
        //Thread is resumed
        //Main finished
        //Woke up
    }
}
