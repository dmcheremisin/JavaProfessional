package $07Concurrency.executors;

import $07Concurrency.Utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledServicesExample {

    static int count = 0;

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        Runnable runnable = () -> {
            Utils.pause(1000);
            System.out.println(count++);
        };
        // executes every task one by one with fixed delay
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);

        // executes every task one by one with fixed delay, but waits until previous task completes
        service.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.SECONDS);
    }
}
