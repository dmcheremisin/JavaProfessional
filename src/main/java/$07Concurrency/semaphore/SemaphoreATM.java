package $07Concurrency.semaphore;

import java.util.concurrent.Semaphore;

class Person extends Thread {
    String name;
    Semaphore sem;

    public Person(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " tries to acquire ATM");
        try {
            sem.acquire();
            System.out.println(name + " acquired ATM");
            Thread.sleep(1000);
            System.out.println(name + " finished using ATM");
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreATM {

    public static void main(String[] args) {
        // there are 2 ATM machines
        Semaphore atms = new Semaphore(2);

        new Person("Bill", atms);
        new Person("Linda", atms);
        new Person("Max", atms);
        new Person("Sonya", atms);
        new Person("Lilly", atms);

        /*
        Bill tries to acquire ATM
        Bill acquired ATM
        Max tries to acquire ATM
        Max acquired ATM
        Linda tries to acquire ATM
        Sonya tries to acquire ATM
        Lilly tries to acquire ATM
        Max finished using ATM
        Linda acquired ATM
        Bill finished using ATM
        Sonya acquired ATM
        Linda finished using ATM
        Lilly acquired ATM
        Sonya finished using ATM
        Lilly finished using ATM
         */
    }
}
