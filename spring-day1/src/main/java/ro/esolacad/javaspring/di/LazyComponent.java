package ro.esolacad.javaspring.di;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy
public class LazyComponent {

    @PostConstruct
    public void init() {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Created LazyComponent");
        System.out.println("--------------------------------------");
        System.out.println();
    }
}
