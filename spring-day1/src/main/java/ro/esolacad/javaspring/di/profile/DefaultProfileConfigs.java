package ro.esolacad.javaspring.di.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
public class DefaultProfileConfigs implements ProfileConfigs{

    @Override
    public void showSomething() {
        System.out.println("i am default!");
    }
}
