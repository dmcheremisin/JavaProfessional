package $07Concurrency.threadMethods;

import $07Concurrency.Utils;

/**
 * Created by Dmitrii on 08.04.2018.
 */
public class WaitWithTimeOut {

    public static void main(String[] args) {
        System.out.println("start");

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    // Utils.pause(5000); bad practice here
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("woke up");
            }
        }).start();

        Utils.pause(1000);
        synchronized (lock) {
            System.out.println("hello");
        }
    }
}
