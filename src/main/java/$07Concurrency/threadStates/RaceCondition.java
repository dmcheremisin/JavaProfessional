package $07Concurrency.threadStates;


import $07Concurrency.Utils;

public class RaceCondition {
    
    volatile static int count = 0;

    static class Task implements Runnable {
        @Override
        public void run() {
            while(true){
                Utils.pause(3000);
                count++;
                System.out.println(count);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
//        1
//        1
//        2
//        2
//        4
//        4
//        5
//        6
//        8
//        7
//        9
//        10
//        11
//        11
    }
}
