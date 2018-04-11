package $07Concurrency.semaphore;

import $07Concurrency.Utils;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(0);

        new Thread(() -> {
            System.out.println("Waiting for signal...");
            sem.acquireUninterruptibly();
            System.out.println("Acquired and now starting!");
            int count = 0;
            while (true) {
                System.out.println(count++);
                Utils.pause(1000);
            }
        }).start();

        Utils.pause(1000);
        System.out.println("Ready...");
        Utils.pause(1000);
        System.out.println("Steady...");
        Utils.pause(1000);
        System.out.println("Go!");

        sem.release();

        //Waiting for signal...
        //Ready...
        //Steady...
        //Go!
        //Acquired and now starting!
        //0
        //1
        //2
        //3
        //4
        //5
    }
}
