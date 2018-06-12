package $07Concurrency.threadCases;

/**
 * Created by Dmitrii on 12.06.2018.
 */
public class SynchronizeByClass extends Thread {
    private static int threadcounter = 0;

    public void run() {
        threadcounter++;
        System.out.println(threadcounter);
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            synchronized (SynchronizeByClass.class) {
                new SynchronizeByClass().start();
            }
        }
        //2
        //1
        //4
        //3
        //5
        //6
        //7
        //8
        //9
        //10
    }
}

