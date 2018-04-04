package $07Concurrency.threadsManipulation;


import $07Concurrency.Utils;

public class VolatileExample {
    
    volatile static boolean RUNNING = true;

    static class Task implements Runnable {

        @Override
        public void run() {
            long count = 0;
            while(RUNNING){
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        System.out.println("Program started");
        Thread thread = new Thread(new Task());
        thread.start();
        Utils.pause(3000);
        RUNNING = false;
        System.out.println("Program finished");
//        Program started
//        Program finished
//        8925782941
    }
}
