package ro.esolacad.javaspring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncComponent {

    @Async
    public void doAsync() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        throw  new RuntimeException("lala");
        System.out.println("Doing Async: " + Thread.currentThread().getName());
    }

    @Async
    public Future<Long> getAsync() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Getting Async:" + Thread.currentThread().getName());
        return new AsyncResult<>(20L);
    }
}
