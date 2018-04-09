package $07Concurrency.locks;

import $07Concurrency.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            try {
                Utils.pause(5000);
            } finally {
                lock.unlock();
            }
        }).start();

        System.out.println("Start");
        Utils.pause(1000);

        System.out.println("Try to enter");
        lock.lock();
        try {
            System.out.println("Got it!");
        } finally {
            lock.unlock();
        }
        //Start
        //Try to enter
        //Got it

    }
}
