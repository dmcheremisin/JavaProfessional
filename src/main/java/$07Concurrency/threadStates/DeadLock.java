package $07Concurrency.threadStates;

import $07Concurrency.Utils;

/**
 * Created by Dmitrii on 05.04.2018.
 */
public class DeadLock {

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a){
                System.out.println(Thread.currentThread() + " " + a);
                Utils.pause(1000);
                synchronized (b){
                    System.out.println("Got it");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b){
                System.out.println(Thread.currentThread() + " " + b);
                Utils.pause(1000);
                synchronized (a){
                    System.out.println("Got it");
                }
            }
        }).start();
    }

}
