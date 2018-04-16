package $07Concurrency.countDownLatch;

import $07Concurrency.Utils;

import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println("ready...");
            startSignal.await();
            System.out.println("working...");
            Utils.pause(2000);
            System.out.println("done " + this);
            doneSignal.countDown();
        } catch (InterruptedException ex) {
        } // return;
    }
}

public class CountDownLatchExample {
    private static final int N = 2;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        startSignal.countDown(); // let all threads proceed
        doneSignal.await(); // wait for all to finish
        System.out.println("all done");
    }
}
