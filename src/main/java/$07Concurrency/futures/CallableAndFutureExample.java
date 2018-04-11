package $07Concurrency.futures;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureExample {

    static class Task implements Callable<Double> {
        @Override
        public Double call() throws Exception {
            double result = 0;
            Random random = new Random();
            for(int i = 0; i < 1_000_000_00; i++){
                result += Math.pow(Math.PI, random.nextDouble());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Double> future = service.submit(new Task());

        try {
            Double aDouble = future.get();
            System.out.println(aDouble);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
        // 1870140.4486455002
        // main thread will be in Park state if service is not shut down
    }
}
