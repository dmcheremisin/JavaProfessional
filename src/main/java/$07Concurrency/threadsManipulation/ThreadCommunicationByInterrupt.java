package $07Concurrency.threadsManipulation;


import $07Concurrency.Utils;

public class ThreadCommunicationByInterrupt {
    
    static class Task implements Runnable {

        @Override
        public void run() {
            long count = 0;
            while(true){
                count++;
                if(Thread.interrupted()){
                    break;
                }
            }
            System.out.println(count);
        }
    }
    
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
        
        Utils.pause(3000);
        thread.interrupt();
        // 3063505496
    }
}
