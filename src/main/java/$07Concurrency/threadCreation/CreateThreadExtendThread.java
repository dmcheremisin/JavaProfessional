package $07Concurrency.threadCreation;

import $07Concurrency.Utils;

/**
 * Created by Dmitrii on 02.04.2018.
 */
public class CreateThreadExtendThread {

    static class Task extends Thread {

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
        System.out.println("Main started");
        new Task("First thread").start();
        new Task("Second thread").start();
        System.out.println("Main finished");
        
        /*
        Main started
        Main finished
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
         */
    }
}
