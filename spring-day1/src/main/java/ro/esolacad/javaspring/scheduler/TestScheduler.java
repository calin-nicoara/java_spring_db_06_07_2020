package ro.esolacad.javaspring.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class TestScheduler {

    @Scheduled(fixedDelay = 2000)
    public void doSomething() {
//        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("------------------------");
            System.out.println("Hello do something fixed delay!");
            System.out.println("------------------------");
//        });

    }

    @Scheduled(fixedRate = 2000)
    public void doSomethingFixedRate() {

//        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("------------------------");
            System.out.println("Hello do something fixed rate!");
            System.out.println("------------------------");
//        });

    }

    @Scheduled(cron = "*/2 * 12 * * ?", zone = "Europe/Bucharest")
    public void doSomethinCron() {
//        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------------");
            System.out.println("Hello do something cron!");
            System.out.println("------------------------");
//        });

    }

}
