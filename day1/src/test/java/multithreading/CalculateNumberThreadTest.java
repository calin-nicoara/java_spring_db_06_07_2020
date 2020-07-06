package multithreading;

import org.junit.jupiter.api.Test;

public class CalculateNumberThreadTest {

    @Test
    public void newThreadTest() {
        CalculateNumberThread calculateNumberThread = new CalculateNumberThread();

//        calculateNumberThread.run();

        System.out.println("Main thread:" + Thread.currentThread().getName());
        calculateNumberThread.start();

        System.out.println("Still on main thread");
    }

    @Test
    public void newRunnableTest() {
        Runnable runnable = () -> {
            long l = CalculateNumber.calculateBigNumber(100000);
            System.out.println("The number is:" + l  + " from runnable on thread" + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);

        thread.start();
    }
}
