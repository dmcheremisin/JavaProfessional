package $07Concurrency.locks;

import $07Concurrency.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly {

    final static Lock lock = new ReentrantLock();

    static class EvilTask implements Runnable{

        @Override
        public void run() {
            lock.lock();
            while(true){}
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");

        new Thread(new EvilTask()).start();
        Utils.pause(1000);

        System.out.println("Lock interruptibly");

        Thread thread = new Thread(() -> {
            System.out.println("Locker started");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
            System.out.println("Got it!");
        });
        thread.start();

        // we can interrupt thread in order it would not wait for the lock
        Utils.pause(3000);
        thread.interrupt();

        // Start
        //Lock interruptibly
        //Locker started
        //Interrupted
        // ...works because EvilTask works
    }
}
