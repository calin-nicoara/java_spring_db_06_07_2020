package ro.esolacad.javaspring.di.circulatdep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Circular2 {

    private Circular1 circular1;

    @Autowired
    public Circular2(final Circular1 circular1) {
        this.circular1 = circular1;
    }

    public void call2() {
        circular1.call1();
    }
}
