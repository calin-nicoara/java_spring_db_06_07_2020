package multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class OficialCounterTest {

    @Test
    public void checkNextInt() {
        OficialCounter oficialCounter = new OficialCounter();

        Runnable counterRunnable = () -> {
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Integer nextInt = oficialCounter.getNextInt();
            System.out.println("Int value: " + nextInt + " on thread: " + Thread.currentThread().getName());
        };

        for(int i = 0; i < 1000; i++) {
            new Thread(counterRunnable).start();
        }

        // Just necessary for test
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Last value: " + oficialCounter.getCurrentInt());
    }

    @Test
    public void checkNextAtomicInt() {
        OficialCounter oficialCounter = new OficialCounter();

        Runnable counterRunnable = () -> {
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Integer nextInt = oficialCounter.getAtomicNext();
            System.out.println("Int value: " + nextInt + " on thread: " + Thread.currentThread().getName());
        };

        for(int i = 0; i < 1000; i++) {
            new Thread(counterRunnable).start();
        }

        // Just necessary for test
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Last value: " + oficialCounter.getCurrentAtomicInt());
    }

}
