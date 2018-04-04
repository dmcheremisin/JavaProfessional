package $07Concurrency.threadsManipulation;

import $07Concurrency.Utils;

public class ThreadCommunicationByCommand {

    final static int NOP = -1;
    final static int STOP = 0;
    final static int STATE = 1;

    static int command = NOP;

    static class Task implements Runnable {

        @Override
        public void run() {
            long count = 0;
            
            outer: 
            while (true) {
                if (Thread.interrupted()) {
                    switch (command) {
                        case NOP:
                            break;
                        case STOP:
                            break outer;
                        case STATE:
                            System.out.println(count);
                            break;
                    }
                }
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Task());
        t.start();

        Utils.pause(3000);
        System.out.println("interrupt 1");
        t.interrupt();

        Utils.pause(3000);
        System.out.println("interrupt 2");
        command = STATE;
        t.interrupt();

        Utils.pause(3000);
        System.out.println("interrupt 3");
        command = STOP;
        t.interrupt();
//        interrupt 1
//        interrupt 2
//        7714903665
//        interrupt 3
//        11773201423

    }
}
