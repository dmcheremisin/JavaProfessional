package $07Concurrency.threadMethods;

import $07Concurrency.Utils;

public class NotifyAll {
    
    static class Runner implements Runnable {
        
        private Object pager;

        public Runner(Object pager) {
            this.pager = pager;
        }

        @Override
        public void run() {
            synchronized (pager){
                try {
                    pager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this + " runner started!");
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");
        
        Object pager = new Object();
        for(int i = 0; i < 3; i++){
            new Thread(new Runner(pager)).start();
        }

        Utils.pause(1000);
        System.out.println("Ready...Steady...Go!");
        
        synchronized (pager){
            pager.notifyAll();
        }
        // begin
        // Ready...Steady...Go!
        // $07Concurrency.threadMethods.NotifyAll$Runner@9a3c87d runner started!
        // $07Concurrency.threadMethods.NotifyAll$Runner@17233e2b runner started!
        // $07Concurrency.threadMethods.NotifyAll$Runner@7e6871bc runner started!
        
    }
}
