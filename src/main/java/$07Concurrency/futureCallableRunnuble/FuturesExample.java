package $07Concurrency.futureCallableRunnuble;

import $07Concurrency.Utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesExample {

    static class Task implements Runnable{
        public String name;
        public Task(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(name);
            Utils.pause(1000);
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<?> one = service.submit(new Task("one"));
        Future<?> two = service.submit(new Task("two"));
        Future<?> three = service.submit(new Task("three"));

        System.out.println("Second is canceled: " + two.cancel(false));

        List<Runnable> tasks = service.shutdownNow();
        System.out.println(tasks);

        //Second is canceled: true
        //one
        //[java.util.concurrent.FutureTask@2503dbd3, java.util.concurrent.FutureTask@4b67cf4d]
        //Something went wrong: sleep interrupted
        //java.lang.InterruptedException: sleep interrupted

    }
}
