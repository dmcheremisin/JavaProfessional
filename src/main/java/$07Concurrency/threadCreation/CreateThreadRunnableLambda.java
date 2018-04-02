package $07Concurrency.threadCreation;

import $07Concurrency.Utils;

/**
 * Created by Dmitrii on 02.04.2018.
 */
public class CreateThreadRunnableLambda {
    public static void main(String[] args) {

        System.out.println("Main started");

        new Thread(() -> {
            System.out.println("First thread started");
            int count = 0;
            while (true) {
                Utils.pause(1000);
                System.out.println(count++);
            }
        }).start();

        Runnable runnable = () -> {
            System.out.println("Second thread started");
            int count = 0;
            while (true) {
                Utils.pause(1000);
                System.out.println(count++);
            }
        };
        new Thread(runnable).start();

        System.out.println("Main thread finished");
        
        /*
        Main started
        First thread started
        Main thread finished
        Second thread started
        0
        0
        1
        1
        2
        2
        3
        3
        4
        4
         */
    }
}
