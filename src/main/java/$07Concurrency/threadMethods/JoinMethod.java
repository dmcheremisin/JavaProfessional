package $07Concurrency.threadMethods;

import $07Concurrency.Utils;

public class JoinMethod {

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("thread started");
            Utils.pause(3000);
            System.out.println("thread finished");
        }
    }

    public static void main(String[] args) {
        System.out.println("main start");
        Thread thread = new Thread(new Task());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
        // main start
        // thread started
        // thread finished
        // main end

    }
}
