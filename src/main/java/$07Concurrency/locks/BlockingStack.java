package $07Concurrency.locks;

import $07Concurrency.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingStack {
    private int size;
    private int currPointer = 0;
    private Object[] elements;

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public BlockingStack(int size){
        this.size = size;
        elements = new Object[size];
    }

    public void insert(Object element){
        lock.lock();
        System.out.println("Counter: " + currPointer);
        try{
            if(currPointer == size){
                System.out.println("Container is full. Waiting for remove of the element...");
                full.await();
                System.out.println("Remove has been called, ready for insertion.");
            }
            elements[currPointer++] = element;
            System.out.println("Inserting the element " + element);
            empty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object remove(){
        lock.lock();
        System.out.println("Counter: " + currPointer);
        Object element = null;
        try{
            if(currPointer == 0) {
                System.out.println("Container is empty. Waiting for insertion of the element...");
                empty.await();
                System.out.println("Insert was called. Ready to remove an element");
            }
            element = elements[--currPointer];
            System.out.println("Removing the element " + element);
            full.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return element;
    }

    public static void main(String[] args) {
        BlockingStack blockingStack = new BlockingStack(3);
        new Thread(() -> {
            blockingStack.remove();
        }).start();
        Utils.pause(1000);

        blockingStack.insert("1");
        blockingStack.insert("2");
        blockingStack.insert("3");
        blockingStack.insert("4");

        Utils.pause(1000);
        new Thread(() -> {
            blockingStack.remove();
        }).start();
        blockingStack.insert("5");

        /*
        Counter: 0
        Container is empty. Waiting for insertion of the element...
        Counter: 0
        Inserting the element 1
        Counter: 1
        Inserting the element 2
        Counter: 2
        Inserting the element 3
        Counter: 3
        Container is full. Waiting for remove of the element...
        Insert was called. Ready to remove an element
        Removing the element 3
        Remove has been called, ready for insertion.
        Inserting the element 4
        Counter: 3
        Container is full. Waiting for remove of the element...
        Counter: 3
        Removing the element 4
        Remove has been called, ready for insertion.
        Inserting the element 5
         */
    }
}
