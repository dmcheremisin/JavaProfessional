package $07Concurrency.threadMethods;


import $07Concurrency.Utils;

public class WaitNotify {

    static class Task implements Runnable {

        private Object pager;

        public Task(Object pager) {
            this.pager = pager;
        }

        @Override
        public void run() {
            synchronized (pager) {
                try {
                    System.out.println("Starting waiting");
                    pager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished waiting");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Started main");
        
        Object obj = new Object();
        new Thread(new Task(obj)).start();

        Utils.pause(3000);
        synchronized (obj) {
            obj.notify();
        }

        System.out.println("Finished main");

//        Started main
//        Starting waiting
//        Finished waiting
//        Finished main
    }
}
