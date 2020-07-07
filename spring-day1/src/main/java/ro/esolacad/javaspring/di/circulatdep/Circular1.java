package ro.esolacad.javaspring.di.circulatdep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Circular1 {

    @Autowired
    private Circular2 circular2;

    public void call1() {
        circular2.call2();
    }
}
