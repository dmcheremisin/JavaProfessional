package $07Concurrency.threadCreation;

public class UseThreadClass {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };

        thread.start();
        // Hello World!
    }
}
