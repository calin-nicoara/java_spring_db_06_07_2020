package multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class ConcurrentApiTest {

    @Test
    public void testExecutorWithRunnable() {
        Runnable runnable = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long l = CalculateNumber.calculateBigNumber(100000);
            System.out.println("The number is:" + l  + " from runnable on thread" + Thread.currentThread().getName());
        };


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    @Test
    public void testCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Long> callable = () -> {
            Thread.sleep(2000);
            return CalculateNumber.calculateBigNumber(100000);
        };

        Future<Long> longFuture = executorService.submit(callable);

//        longFuture.isDone()

        try {
            Long aLong = longFuture.get();
            System.out.println("Number from future: " + aLong);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIntreruptFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Long> callable = () -> {
            Thread.sleep(2000);
            return CalculateNumber.calculateBigNumber(100000);
        };

        Future<Long> longFuture = executorService.submit(callable);
        Future<Long> longFuture2 = executorService.submit(callable);
        Future<Long> longFuture3 = executorService.submit(callable);
        Future<Long> longFuture4 = executorService.submit(callable);

        try {
            Long aLong = longFuture.get();
            System.out.println("Number from future: " + aLong);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScheduled() {
        Runnable runnable = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long l = CalculateNumber.calculateBigNumber(100000);
            System.out.println("The number is:" + l  + " from runnable on thread" + Thread.currentThread().getName());
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleWithFixedDelay(runnable, 1, 2, TimeUnit.SECONDS);


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThreadLocal() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        OficialCounter oficialCounter = new OficialCounter();

        Runnable counterRunnable = () -> {
            Integer nextInt = oficialCounter.getAtomicNextAndSetOnThreadLocal();
        };

        for(int i = 0; i < 20; i++) {
            executorService.execute(counterRunnable);
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
