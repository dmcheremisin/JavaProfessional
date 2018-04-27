package $07Concurrency.locks;

import $07Concurrency.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Person extends Thread {
    String name;
    Lock lock;

    public Person(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " tries to acquire ATM");
        Utils.pause(500);
        try {
            lock.lock();
            System.out.println(name + " acquired ATM");
            Thread.sleep(1000);
            System.out.println(name + " finished using ATM");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LocksATM {

    public static void main(String[] args) {
        // there is only one ATM machine
        Lock atms = new ReentrantLock();

        new Person("Bill", atms);
        new Person("Linda", atms);
        new Person("Max", atms);
        new Person("Sonya", atms);
        new Person("Lilly", atms);

        /*
        Bill tries to acquire ATM
        Linda tries to acquire ATM
        Sonya tries to acquire ATM
        Max tries to acquire ATM
        Lilly tries to acquire ATM
        Max acquired ATM
        Max finished using ATM
        Linda acquired ATM
        Linda finished using ATM
        Sonya acquired ATM
        Sonya finished using ATM
        Lilly acquired ATM
        Lilly finished using ATM
        Bill acquired ATM
        Bill finished using ATM
         */
    }
}
