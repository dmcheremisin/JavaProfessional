package $07Concurrency.locks;

import $07Concurrency.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RailwayStation {
    private static Lock station = new ReentrantLock();
    private static Condition joeArrival = station.newCondition();

    static class Train extends Thread {
        public Train(String name){
            setName(name);
        }

        @Override
        public void run() {
            station.lock();
            try {
                System.out.println(getName() + ": I've arrived in station ");
                if(getName().contains("IC1122")) {
                    joeArrival.signalAll();
                }
            } finally {
                station.unlock();
            }
        }
    }

    static class WaitForJoe extends Thread {
        @Override
        public void run() {
            System.out.println("Waiting in the station for IC1122 in which Joe is coming");
            station.lock();
            try {
                joeArrival.await();
                System.out.println("Pick up Joe and go home");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                station.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new WaitForJoe().start();
        Utils.pause(500);

        new Train("IC1234 - Paris to Munich").start();
        Utils.pause(500);
        new Train("IC2211 - Paris to Madrid").start();
        Utils.pause(500);
        new Train("IC1122 - Madrid to Paris").start();
        Utils.pause(500);
        new Train("IC4321 - Munich to Paris").start();

        /*
        Waiting in the station for IC1122 in which Joe is coming
        IC1234 - Paris to Munich: I've arrived in station
        IC2211 - Paris to Madrid: I've arrived in station
        IC1122 - Madrid to Paris: I've arrived in station
        Pick up Joe and go home
        IC4321 - Munich to Paris: I've arrived in station
         */
    }
}
