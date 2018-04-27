package $07Concurrency.futures;

import java.util.concurrent.*;

public class FactorialWithCallable implements Callable<Long> {

    long factPower;

    public FactorialWithCallable(int factPower) {
        this.factPower = factPower;
    }

    @Override
    public Long call() throws Exception {
        Long result = 1L;
        for(long i = 1; i <= factPower; i++){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        FactorialWithCallable callable = new FactorialWithCallable(25);
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Long> result = service.submit(callable);

        // Will wait until the future completes
        System.out.println("AND the result is: " + result.get());
        service.shutdown();
        //AND the result is: 7034535277573963776
    }
}
