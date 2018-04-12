package $07Concurrency.executors;

import $07Concurrency.Utils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run implements Runnable {
    @Override
    public void run() {
        Utils.pause(1000);
        System.out.println("hello");
    }
}

public class FixedThreadExecutorExample {
    public static void main(String[] args) {
        System.out.println("start");

        ExecutorService service = Executors.newFixedThreadPool(2); // 2 threads will be used

        service.execute(new Run());
        service.execute(new Run());
        service.execute(new Run());
        service.execute(new Run());

        Utils.pause(1000);
//		service.shutdown();
        List<Runnable> RunsLeft = service.shutdownNow();
        System.out.println(RunsLeft);

        System.out.println("finish");

        //start
        //[$07Concurrency.executors.Run@2503dbd3, $07Concurrency.executors.Run@4b67cf4d]
        //finish
        //hello
        //hello
        //Something went wrong: sleep interrupted
        //Something went wrong: sleep interrupted
        //java.lang.InterruptedException: sleep interrupted
    }
}
