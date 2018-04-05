package $07Concurrency.threadConditions;

import $07Concurrency.Utils;

public class Starvation {

    public static void main(String[] args) {
        System.out.println("start");

        Object pager = new Object();
        
        new Thread(() -> {
            synchronized (pager) { // locks pager
                try {
                    pager.wait(); // frees pager and waits for the signal from the main thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Huuuray!");
        }).start();

        Utils.pause(2000);
        
        synchronized (pager){ // locks pager
            pager.notify(); // notifies that pager is free
            while (true){} // but doesn't release lock here -> main thread is RUNNING, new Thread is in MONITOR state
        }
        // start
        // ...waiting forever - starvation
    }

}
