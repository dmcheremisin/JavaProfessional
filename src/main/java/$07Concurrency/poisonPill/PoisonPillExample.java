package $07Concurrency.poisonPill;

import $07Concurrency.Utils;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dmitrii on 08.04.2018.
 */
class WorkerThread {
    Queue<Runnable> tasks = new LinkedList<>();
    static final Runnable POISON_PILL = () -> {};

    WorkerThread() {
        new Thread(this::startWork).start();
    }
    void submit(Runnable runnable) {
        synchronized (tasks) {
            tasks.offer(runnable);
            tasks.notify();
        }
    }
    void shutdown(){
        submit(POISON_PILL);
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
            if(task == POISON_PILL){
                System.out.println("Got poison pill and stopping!");
                break;
            }
            task.run();
        }
    }
}
public class PoisonPillExample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + " started");
            Utils.pause(2000);
        };

        WorkerThread workerThread = new WorkerThread();
        workerThread.submit(runnable);
        workerThread.submit(runnable);
        workerThread.submit(runnable);
        workerThread.shutdown();
        workerThread.submit(runnable);
        // Thread[Thread-0,5,main] started
        //Thread[Thread-0,5,main] started
        //Thread[Thread-0,5,main] started
        //Got poison pill and stopping!
    }
}
