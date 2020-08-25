package ro.esolacad.javaspring.async;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AsyncComponentUser {

    private final AsyncComponent asyncComponent;

    public void test() {
        System.out.println("Start of test");
        asyncComponent.doAsync();
        Future<Long> async = asyncComponent.getAsync();
        System.out.println("End of test");

        try {
            System.out.println(async.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
