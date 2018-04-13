package $07Concurrency.executors;

import $07Concurrency.Utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadExecutorExample {
    static class Task implements Runnable {
        @Override
        public void run() {
            Utils.pause(1000);
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        System.out.println("start");

        ExecutorService service = Executors.newCachedThreadPool();
        while(true){
            Utils.pause(200);
            service.execute(new Task());
        }

        // start
        //hello
        //hello
        //hello
        //hello
        //hello
        //hello
        //hello
        //hello
        // 5 threads are created to run these tasks
    }
}
