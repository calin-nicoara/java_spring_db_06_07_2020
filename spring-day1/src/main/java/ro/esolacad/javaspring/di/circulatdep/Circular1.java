package ro.esolacad.javaspring.di.circulatdep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Circular1 {

    private Circular3 circular3;

    @Autowired
    public Circular1(final Circular3 circular3) {
        this.circular3 = circular3;
    }

    public void call1() {
        circular3.call3();
    }
}
