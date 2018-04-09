package $07Concurrency.blockingQueue;

import $07Concurrency.Utils;

class WorkerThread {
    BlockingQueue<Runnable> tasks = new BlockingQueue<>();
    static final Runnable POISON_PILL = () -> {};
    private boolean mayAcceptTasks = true;

    WorkerThread() {
        new Thread(this::startWork).start();
    }
    boolean submit(Runnable runnable) {
        if(!mayAcceptTasks){
            return false;
        }
        if(runnable == POISON_PILL){
            mayAcceptTasks = false;
        }
        tasks.put(runnable);
        return true;
    }
    void shutdown(){
        submit(POISON_PILL);
    }
    private void startWork() {
        while (true) {
            Runnable task = tasks.take();
            if(task == POISON_PILL){
                System.out.println("Got poison pill and stopping!");
                break;
            }
            task.run();
        }
    }
}
public class WorkerThreadWithBlockingQueue {
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
        // Thread[Thread-0,5,main] started
        // Thread[Thread-0,5,main] started
        // Got poison pill and stopping!
    }
}