package $07Concurrency.executors;

import $07Concurrency.Utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private int millis;
    public Task() {
        this.millis = 1000;
    }
    @Override
    public void run() {
        Utils.pause(millis);
        System.out.println("hello");
    }
}

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        System.out.println("start");

		ExecutorService service = Executors.newSingleThreadExecutor(); // serial
//      ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());

        Utils.pause(1000);
//		service.shutdown();
        List<Runnable> tasksLeft = service.shutdownNow();
        System.out.println(tasksLeft);

        System.out.println("finish");

        // start
        //[$07Concurrency.executors.Task@330bedb4, $07Concurrency.executors.Task@2503dbd3, $07Concurrency.executors.Task@4b67cf4d]
        //finish
        //hello
    }
}
