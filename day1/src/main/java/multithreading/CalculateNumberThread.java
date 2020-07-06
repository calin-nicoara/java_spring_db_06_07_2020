package multithreading;

public class CalculateNumberThread extends Thread {

    @Override
    public void run() {
        long l = CalculateNumber.calculateBigNumber(100000);
        System.out.println("The number is:" + l  + " on thread" + Thread.currentThread().getName());
    }
}
