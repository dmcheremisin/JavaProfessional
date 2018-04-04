package $07Concurrency.threadsManipulation;

import $07Concurrency.Utils;

public class SyncByClassOrObject {

    private static void printCounter() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Utils.pause(1000);
        }
    }

    static private void printByClass() {
        synchronized (SyncByClassOrObject.class) {
            printCounter();
        }
    }
    private void printByObject() {
        synchronized (this) {
            printCounter();
        }
    }

    public static void main(String[] args) {
        new Thread(SyncByClassOrObject::printByClass).start();
        printByClass();
//        main 0
//        main 1
//        main 2
//        Thread-0 0
//        Thread-0 1
//        Thread-0 2
        
        Utils.pause(3000);

        SyncByClassOrObject sync = new SyncByClassOrObject();
        new Thread(sync::printByObject).start();
        sync.printByObject();
//        main 0
//        main 1
//        main 2
//        Thread-1 0
//        Thread-1 1
//        Thread-1 2
    }
}
