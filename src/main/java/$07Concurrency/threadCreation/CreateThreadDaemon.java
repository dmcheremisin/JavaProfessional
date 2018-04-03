package $07Concurrency.threadCreation;

import $07Concurrency.Utils;

public class CreateThreadDaemon {

    static class Counter implements Runnable {

        @Override
        public void run() {
            System.out.println("Daemon started");
            int count = 0;
            while (true) {
                System.out.println(++count);
                Utils.pause(1000);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Main started");
        Thread thread = new Thread(new Counter());
        thread.setDaemon(true);
        thread.start();
        Utils.pause(3000);
        System.out.println("Main finished");
//        Main started
//        Daemon started
//        1
//        2
//        3
//        4
//        Main finished
    }
}
