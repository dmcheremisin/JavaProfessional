package $07Concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemCounter {

    int count = 0;
    public Semaphore sem = new Semaphore(1);

    public int get(){
        sem.acquireUninterruptibly();
        try{
            return count;
        } finally{
            sem.release();
        }
    }

    public void set(int count) {
        sem.acquireUninterruptibly();
        try{
            this.count = count;
        } finally {
            sem.release();
        }
    }
}
