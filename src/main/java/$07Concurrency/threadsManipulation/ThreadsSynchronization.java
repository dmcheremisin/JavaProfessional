package $07Concurrency.threadsManipulation;

import $07Concurrency.Utils;

public class ThreadsSynchronization {
    volatile static int count = 0;

    static class Task implements Runnable {
        @Override
        public void run() {
            while(true){
                Utils.pause(3000);
                inc();
            }
        }

        synchronized private void inc() {
            count++;
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
//        1
//        2
//        3
//        4
//        5
//        6
//        7
//        8
//        9
//        10
    }

}
