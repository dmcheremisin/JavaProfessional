package $07Concurrency.threadMethods;

import $07Concurrency.Utils;

import java.util.Arrays;

/**
 * Created by Dmitrii on 08.04.2018.
 */
public class Stop {

    static class Task implements Runnable{

        Object lock = new Object();

        int x = 0;
        int y = 0;
        // x + y should be always == 0

        @Override
        public void run() {
            synchronized (lock) {
                x += 10;
                Utils.pause(2000);
                y -= 10;
            }
        }

        public int[] get(){
            int[] ints = new int[2];
            synchronized (lock){
                ints[0] = x;
                ints[1] = y;
            }
            return ints;
        }
    }

    public static void main(String[] args) {
        System.out.println("start");

        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        Utils.pause(1000);
        thread.stop();

        System.out.println(Arrays.toString(task.get()));
        System.out.println("stop");

        //start
        //[10, 0]
        //stop
        // task object is not stable, because we stopped thread during task change

    }
}
