package $07Concurrency.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample {
    static int NUM_THREADS = 10;
    static long N = 10000;

    static class RecursiveSum extends RecursiveTask<Long> {
        long from, to;

        public RecursiveSum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if(to - from < N / NUM_THREADS) {
                long sum = 0L;
                for(long i = from; i <= to; i++) {
                    sum += i;
                }
                return sum;
            } else {
                long mid = (from + to) /2;
                System.out.printf("Forking computation into two ranges: %d to %d and %d to %d %n", from, mid, mid, to);
                RecursiveSum firstHalf = new RecursiveSum(from, mid);
                RecursiveSum secondHalf = new RecursiveSum(mid+1, to);

                secondHalf.fork();

                Long firstSum = firstHalf.compute();
                Long secondSum = secondHalf.join();

                return firstSum + secondSum;
            }
        }
    }
    public static void main(String[] args) {
        ForkJoinPool fjPool = new ForkJoinPool(NUM_THREADS);

        Long computedSum = fjPool.invoke(new RecursiveSum(0, N));

        long formulaSum = (N * (N + 1) /2);

        System.out.printf("Sum for range 1..%d; computed sum = %d, formula sum = %d %n", N, computedSum, formulaSum);
    }

    /*
    Forking computation into two ranges: 0 to 5000 and 5000 to 10000
    Forking computation into two ranges: 0 to 2500 and 2500 to 5000
    Forking computation into two ranges: 5001 to 7500 and 7500 to 10000
    Forking computation into two ranges: 2501 to 3750 and 3750 to 5000
    Forking computation into two ranges: 0 to 1250 and 1250 to 2500
    Forking computation into two ranges: 7501 to 8750 and 8750 to 10000
    Forking computation into two ranges: 2501 to 3125 and 3125 to 3750
    Forking computation into two ranges: 5001 to 6250 and 6250 to 7500
    Forking computation into two ranges: 8751 to 9375 and 9375 to 10000
    Forking computation into two ranges: 7501 to 8125 and 8125 to 8750
    Forking computation into two ranges: 3751 to 4375 and 4375 to 5000
    Forking computation into two ranges: 1251 to 1875 and 1875 to 2500
    Forking computation into two ranges: 0 to 625 and 625 to 1250
    Forking computation into two ranges: 5001 to 5625 and 5625 to 6250
    Forking computation into two ranges: 6251 to 6875 and 6875 to 7500
    Sum for range 1..10000; computed sum = 50005000, formula sum = 50005000
     */
}
