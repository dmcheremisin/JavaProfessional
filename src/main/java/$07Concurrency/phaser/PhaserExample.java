package $07Concurrency.phaser;

import $07Concurrency.Utils;

import java.util.concurrent.Phaser;

class Worker extends Thread {
    String name;
    Phaser phaser;

    public Worker(String name, Phaser phaser){
        this.name = name;
        this.phaser = phaser;
        phaser.register();
        start();
    }

    @Override
    public void run() {
        System.out.println(name + " starts working");
        for(int i = 1; i <= 3; i++) {
            Utils.pause(200);
            System.out.println(name + ": finished phase number №" + i);
            if(i < 3){
                phaser.arriveAndAwaitAdvance();
            }
        }
        phaser.arriveAndDeregister();
    }
}
public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        new Worker("Cooker", phaser);
        new Worker("Supplier", phaser);
        new Worker("Assistant", phaser);

        for(int i = 1; i <= 3; i++) {
            Utils.pause(1000);
            System.out.println("===========> Finished phase number № " + i);
            if(i < 3){
                phaser.arriveAndAwaitAdvance();
            }
        }
        phaser.arriveAndDeregister();
        System.out.println("Thanks to eveybody for their job!");
    }

    /*
    Cooker starts working
    Assistant starts working
    Supplier starts working
    Cooker: finished phase number №1
    Assistant: finished phase number №1
    Supplier: finished phase number №1
    ===========> Finished phase number № 1
    Cooker: finished phase number №2
    Supplier: finished phase number №2
    Assistant: finished phase number №2
    ===========> Finished phase number № 2
    Assistant: finished phase number №3
    Supplier: finished phase number №3
    Cooker: finished phase number №3
    ===========> Finished phase number № 3
    Thanks to eveybody for their job!
     */
}
