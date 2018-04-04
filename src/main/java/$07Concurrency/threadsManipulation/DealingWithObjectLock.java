package $07Concurrency.threadsManipulation;

import $07Concurrency.Utils;

public class DealingWithObjectLock {
    
    static class Counter {
        private int count;
        private Object lock = new Object();
        
        // it is better to synchronize this method by mutex in order to bypass object lock in evil thread
        // synchronized public int getCount -> will lead to the no operational possibility
        public int getCount() {
            synchronized (lock) {
                return count;
            }
        }
        public void inc() {
            synchronized (lock) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter();

        System.out.println("starting evil thread");

        // it will lock the whole object for work -> synchronized (c)
        new Thread(() -> {
            synchronized (c) {
                while(true) {}
            }
        }).start();

        Utils.pause(1000);

        System.out.println("starting good threads");

        // increments counter
        new Thread(() -> {
            while (true) {
                c.inc();
                Utils.pause(1000);
            }
        }).start();
        
        // prints counter value
        new Thread(() -> {
            while (true) {
                System.out.println(c.getCount());
                Utils.pause(1000);
            }
        }).start();
        
//        starting evil thread
//        starting good threads
//        0
//        2
//        3
//        3
//        5
//        6
//        7
//        8
//        9
//        10
    }
}
