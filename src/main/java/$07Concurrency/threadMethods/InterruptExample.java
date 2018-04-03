package $07Concurrency.threadMethods;

import $07Concurrency.Utils;

public class InterruptExample {
    
    static class Task implements Runnable {

        @Override
        public void run() {
            long count = 0;
            while(true){
                count++;
                if(Thread.interrupted()){
                    System.out.println(count);
                }
                // this method will not erase interrupted flag - if interrupted, it will always return true
                //boolean interrupted = Thread.currentThread().isInterrupted();
            }
        }
    }
    
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
        
        while(true){
            Utils.pause(1000);
            thread.interrupt();
        }
//        860396352
//        2124332523
//        3447474998
//        4774641829
//        6042743115
    }
}
