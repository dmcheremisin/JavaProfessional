package $07Concurrency.semaphore;

import $07Concurrency.Utils;

import java.util.concurrent.Semaphore;

/*
The argument to the Semaphore instance is the number of "permits" that are available. It can be any integer, not just 0 or 1.

public static Semaphore semZero = new Semaphore(0);
For semZero all acquire() calls will block and tryAcquire() calls will return false, until you do a release()

public static Semaphore semOne = new Semaphore(1);
For semOne the first acquire() calls will succeed and the rest will block until the first one releases.
 */

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
