package multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    @Test
    public void testThenAccept() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> new Random().nextInt(1000))
                .thenApplyAsync(a -> a + 100);

//        integerCompletableFuture.thenAccept(System.out::println);

        integerCompletableFuture.join();

        System.out.println(integerCompletableFuture.getNow(0));
    }
}
