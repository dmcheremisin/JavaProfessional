package $07Concurrency.futures;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExamples {

    public static void main(String[] args) {
        CompletableFuture<Void> helloWorld = CompletableFuture.runAsync(() -> {
            System.out.println("hello");
        }).thenRun(() -> {
            System.out.println("world!");
        });

        CompletableFuture<Void> andAgain = CompletableFuture.runAsync(() -> {
            System.out.println("And again!");
        });
    }
}
