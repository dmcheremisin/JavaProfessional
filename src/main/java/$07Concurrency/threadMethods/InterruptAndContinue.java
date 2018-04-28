package $07Concurrency.threadMethods;

/**
 * Created by Dmitrii on 28.04.2018.
 */
public class InterruptAndContinue extends Thread {
    private int numberThreads;
    private int time;

    static class SecondClass extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            System.out.println("finished");
        }
    }

    InterruptAndContinue(int numberThreads, int time){
        this.numberThreads = numberThreads;
        this.time = time;
    }

    public static void main(String[] args) {
        InterruptAndContinue object = new InterruptAndContinue(6, 1000);
        object.start();
        //wait in main thread
        try {
            object.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is finished");
    }

    public void run() {
        SecondClass[] secObj= new SecondClass[numberThreads];
        //start all
        for (int i = 0; i < numberThreads; i++) {
            secObj[i] = new SecondClass();
            secObj[i].start();
        }
        try {
            //wait
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Interrupt all
        for (int i = 0; i < numberThreads; i++) {
            secObj[i].interrupt();
        }
        System.out.println("InterruptAndContinue is finished");
    }

    /*
    interrupted
    interrupted
    finished
    finished
    interrupted
    finished
    interrupted
    finished
    interrupted
    finished
    InterruptAndContinue is finished
    interrupted
    finished
    Main thread is finished
     */
}
