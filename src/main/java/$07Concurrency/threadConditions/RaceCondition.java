package $07Concurrency.threadConditions;


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
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
//        1
//        2
//        2
//        3
//        4
    }
}
