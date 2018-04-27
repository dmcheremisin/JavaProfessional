package $07Concurrency.futureCallableRunnuble;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PartialSumCallable {
    private static int THREADS = 10;
    private static long NUM = 1_000_000_000L;
    private static long sum = 0;

    static class SumCallable implements Callable<Long> {
        long from, to;

        public SumCallable(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long result = 0L;
            for(long i = from; i <= to; i++){
                result += i;
            }
            return result;
        }
    }

    public static void main(String[] args) throws Exception{
        List<Future<Long>> futures = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(THREADS);
        Long part = NUM / THREADS;
        int from = 0;
        int to = 0;
        for(int i = 0; i < THREADS; i++){
            from = to;
            to += part;
            SumCallable sumCallable = new SumCallable(from, to);
            Future<Long> future = service.submit(sumCallable);
            futures.add(future);
        }

        for (Future<Long> future : futures) {
            sum += future.get();
        }
        System.out.println("The sum = " + sum);
        service.shutdown();
        // The sum = 500000005000000000
    }

}
