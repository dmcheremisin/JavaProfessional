package $07Concurrency.threadCreation;

import $07Concurrency.Utils;

public class CreateThread {
    
    static class Task implements Runnable {
        
        private String name;
        
        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(name);
            System.out.println(Thread.currentThread().getName() + " started");
            int count = 0;
            while(true) {
                Utils.pause(1000);
                System.out.println(count++);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Started main thread");
        new Task("Task thread").run();
        System.out.println("Finished main thread");
    }
    // Started main thread
    // Task thread started
    // 0
    // 1
    // 2
    // 3
    // 4
}
