package ro.esolacad.javaspring.di.circulatdep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Circular3 {
    private Circular2 circular2;

    @Autowired
    public Circular3(final Circular2 circular2) {
        this.circular2 = circular2;
    }

    public void call3() {
        circular2.call2();
    }
}
