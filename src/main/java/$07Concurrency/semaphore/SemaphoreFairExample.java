package $07Concurrency.semaphore;

import $07Concurrency.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreFairExample {
    static class Task implements Runnable{
        Semaphore sem;
        int number;

        public Task(Semaphore sem, int number) {
            this.sem = sem;
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println(number + " trying to acquire");
            sem.acquireUninterruptibly();
            System.out.println(number + " started");
        }
    }

    public static void main(String[] args) {
        // creates fair semaphore
        Semaphore sem = new Semaphore(0, true);

        List<Task> tasks = Arrays.asList(new Task(sem, 1), new Task(sem, 2), new Task(sem, 3), new Task(sem, 4), new Task(sem, 5));

        ExecutorService service = Executors.newCachedThreadPool();
        for (Task task : tasks) {
            service.execute(task);
            Utils.pause(200);
        }
        Utils.pause(1500);

        System.out.println("Ready....Steady....Go!");

        sem.release(3);

        //1 trying to acquire
        //2 trying to acquire
        //3 trying to acquire
        //4 trying to acquire
        //5 trying to acquire
        //Ready....Steady....Go!
        //1 started
        //2 started
        //3 started
        // ==========================================================
        // if Semaphore sem = new Semaphore(0, false); result will be:
        //
        //1 trying to acquire
        //2 trying to acquire
        //3 trying to acquire
        //4 trying to acquire
        //5 trying to acquire
        //Ready....Steady....Go!
        //1 started
        //3 started
        //2 started
    }
}
