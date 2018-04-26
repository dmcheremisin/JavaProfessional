package $07Concurrency.countDownLatch;

import $07Concurrency.Utils;

import java.util.concurrent.CountDownLatch;

class Runner extends Thread {
    String name;
    CountDownLatch timer;

    public Runner(String name, CountDownLatch timer) {
        this.name = name;
        this.timer = timer;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " is ready to start race");
        try {
            timer.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " started running");
    }
}

public class RaceExample {
    public static void main(String[] args) {
        CountDownLatch timer = new CountDownLatch(5);
        new Runner("Jack", timer);
        new Runner("Carl", timer);
        new Runner("Bill", timer);

        while(timer.getCount() > 1){
            Utils.pause(1000);
            System.out.println(timer.getCount());
            timer.countDown();
        }
        System.out.println("Ready....Steady....Go!");
        timer.countDown();

        /*
        Jack is ready to start race
        Carl is ready to start race
        Bill is ready to start race
        5
        4
        3
        2
        Ready....Steady....Go!
        Jack started running
        Bill started running
        Carl started running
         */
    }
}
