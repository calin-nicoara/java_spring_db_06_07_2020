package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class OficialCounter {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int nextInt = 0;

    private static ThreadLocal<Integer> currentIntForThread = new ThreadLocal<>();

//    public synchronized Integer getNextInt() {
//        return ++nextInt;
//    }

    public Integer getNextInt() {
        return ++nextInt;
    }

    public Integer getCurrentInt() {
        return nextInt;
    }

    public Integer getAtomicNext() {
        return atomicInteger.incrementAndGet();
    }

    public Integer getCurrentAtomicInt() {
        return atomicInteger.get();
    }

    public Integer getAtomicNextAndSetOnThreadLocal() {
        int i = atomicInteger.incrementAndGet();

        System.out.println("Current value: " + currentIntForThread.get() + " thread: " + Thread.currentThread().getName());

        currentIntForThread.set(i);
        System.out.println("New Value: " + i + " thread: " + Thread.currentThread().getName());

        return i;
    }
}
