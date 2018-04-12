package $07Concurrency.atomics;

import $07Concurrency.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dmitrii on 12.04.2018.
 */
public class AtomicExample {

    public static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable run = () -> {
            while(true) {
                Utils.pause(1000);
                int c = count.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + c);
            }
        };

        executorService.execute(run);
        executorService.execute(run);
        executorService.execute(run);

        //pool-1-thread-2 2
        //pool-1-thread-3 1
        //pool-1-thread-1 3
        //pool-1-thread-2 4
        //pool-1-thread-3 6
        //pool-1-thread-1 5
        //pool-1-thread-3 8
        //pool-1-thread-1 9
        //pool-1-thread-2 7
        //pool-1-thread-1 10
        //pool-1-thread-3 11
        //pool-1-thread-2 12
        //....
    }
}
