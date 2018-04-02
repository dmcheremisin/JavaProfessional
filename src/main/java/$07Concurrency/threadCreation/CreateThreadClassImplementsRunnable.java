package $07Concurrency.threadCreation;

import $07Concurrency.Utils;

/**
 * Created by Dmitrii on 02.04.2018.
 */
public class CreateThreadClassImplementsRunnable {
    
    static class Task implements Runnable {
        
        private String name;
        
        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName(name);
            System.out.println(currentThread.getName() + " started");
            int count = 0;
            while(true) {
                Utils.pause(1000);
                System.out.println(count++);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Started main thread");
        new Thread(new Task("First thread")).start();
        new Thread(new Task("Second thread")).start();
        System.out.println("Finished main thread");
    }
    /*
    Started main thread
    Finished main thread
    First thread started
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
    5
    5
     */
}
