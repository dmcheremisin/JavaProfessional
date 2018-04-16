package $07Concurrency.semaphore;

import $07Concurrency.Utils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreAsResourceUsageRegulator {

    static final Random r = new Random();
    private static final int MAX = 1000000;

    static double[] generate() {
        double[] data = new double[MAX];
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextDouble();
        }
        Utils.pause(500);
        return data;
    }

    public static void main(String[] args) {

//		ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service = Executors.newFixedThreadPool(2);

        Semaphore sem = new Semaphore(2);

        while (true) {
            double[] data = generate();
            System.out.println("Generated!");
            sem.acquireUninterruptibly();
            service.submit(() -> {
                double sum = 0;
                for (int i = 0; i < data.length; i++) {
                    sum += data[i];
                }
                System.out.println(Thread.currentThread().getName() + " total: " + sum);
                sem.release();
            });
        }

        //Generated!
        //pool-1-thread-1 total: 499724.9212917237
        //Generated!
        //pool-1-thread-2 total: 499664.869228776
        //Generated!
        //pool-1-thread-1 total: 499929.78705177066
        //Generated!
        //pool-1-thread-2 total: 499416.3317519768
        //Generated!
        //pool-1-thread-1 total: 500015.4923889134
        //Generated!
        //pool-1-thread-2 total: 500164.59003041557
        //Generated!
        //pool-1-thread-1 total: 500097.277804023
        //Generated!
        //pool-1-thread-2 total: 500339.540868629


    }

}
