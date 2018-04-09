package $07Concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Dmitrii on 09.04.2018.
 */
public class MultipleLocks {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        System.out.println(lock.getHoldCount());

        lock.lock();
        System.out.println(lock.getHoldCount());

        lock.lock();
        System.out.println(lock.getHoldCount());

        lock.lock();
        System.out.println(lock.getHoldCount());

        while(lock.getHoldCount() != 0){
            System.out.println("Unlock");
            lock.unlock();
        }

        // 0
        //1
        //2
        //3
        //Unlock
        //Unlock
        //Unlock
    }
}
