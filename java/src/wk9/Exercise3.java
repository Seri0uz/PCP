package wk9;

import java.util.concurrent.CompletableFuture;

public class Exercise3 {
    static void main (String[] args) throws InterruptedException {
        CompletableFuture<Long> longLastingTaskFuture =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    System.out.print(3000);
                    return 3000L;
                });
        CompletableFuture<Long> evenLongerLastingTaskFuture =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    System.out.print(6000);
                    return 6000L;
                });

        CompletableFuture<String> lastTaskFuture =
                longLastingTaskFuture.thenCombineAsync(
                        evenLongerLastingTaskFuture,
                        (s, t) -> {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                            }
                            return "was waiting for " + (s + t + 2000) + "ms";
                        });
        CompletableFuture<Void> outputFuture =
                lastTaskFuture.thenAccept(System.out::print);

        System.out.println("-> Now waiting for things to happen!");

        while (!outputFuture.isDone()) {
            Thread.sleep(500);
            System.out.print(".");
        }
        outputFuture.join();
        System.out.println(" -> Done.");
    }
}
