package $07Concurrency.worker;


import static $07Concurrency.worker.SimpleWorker.startWork;

class SimpleWorker {

    // creates every time new Thread - it is bad for performance when there are a lot of tasks to do
    static void startWork(Runnable runnable){
        new Thread(runnable).start();
    }
}

public class UseWorkerSimpleWorker {

    public static void main(String[] args) {
        startWork(() -> {
            System.out.println(Thread.currentThread() + " started working!");
        });
        startWork(() -> {
            System.out.println(Thread.currentThread() + " started working!");
        });
        startWork(() -> {
            System.out.println(Thread.currentThread() + " started working!");
        });
        
        // Thread[Thread-0,5,main] started working!
        // Thread[Thread-1,5,main] started working!
        // Thread[Thread-2,5,main] started working!
    }
}
