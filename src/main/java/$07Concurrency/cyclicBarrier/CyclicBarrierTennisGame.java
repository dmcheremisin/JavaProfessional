package $07Concurrency.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Player extends Thread{
    String name;
    CyclicBarrier barrier;

    public Player(String name, CyclicBarrier cyclicBarrier){
        this.name = name;
        this.barrier = cyclicBarrier;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " is ready to start");
        try {
            Thread.sleep(1000);
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is playing");
    }
}

public class CyclicBarrierTennisGame {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("All players are ready to play - starting!"));
        new Player("John", barrier);
        new Player("Lusi", barrier);
        new Player("Barak", barrier);
        new Player("Melani", barrier);
    }
}
