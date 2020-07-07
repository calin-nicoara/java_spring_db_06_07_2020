package ro.esolacad.javaspring.di.profile;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
//@Primary
public class DevProfile implements ProfileConfigs{
    @Override
    public void showSomething() {
        System.out.println("I am DEV!");
    }
}
