package $07Concurrency.worker;

import $07Concurrency.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// works in one thread created in the constructor
class WorkerThread {
    Queue<Runnable> tasks = new LinkedList<>();

    WorkerThread() {
        new Thread(this::startWork).start();
    }
    void submit(Runnable runnable) {
        synchronized (tasks) {
            tasks.offer(runnable);
            tasks.notify();
        }
    }
    private void startWork() {
        while (true) {
            Runnable task;
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                task = tasks.poll();
            }
            task.run();
        }
    }
}

public class UseWorkerThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + " started");
            Utils.pause(2000);
        };
        
        WorkerThread workerThread = new WorkerThread();
        workerThread.submit(runnable);
        workerThread.submit(runnable);
        workerThread.submit(runnable);
        workerThread.submit(runnable);

        Utils.pause(10000);
        
        // WorkerThread is the same is single thread executor 
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(runnable);
        service.submit(runnable);
        service.submit(runnable);
        service.submit(runnable);
        
//        Thread[Thread-0,5,main] started
//        Thread[Thread-0,5,main] started
//        Thread[Thread-0,5,main] started
//        Thread[Thread-0,5,main] started
//        Thread[pool-1-thread-1,5,main] started
//        Thread[pool-1-thread-1,5,main] started
//        Thread[pool-1-thread-1,5,main] started
//        Thread[pool-1-thread-1,5,main] started
//            ...wait both for other tasks
    }

}
