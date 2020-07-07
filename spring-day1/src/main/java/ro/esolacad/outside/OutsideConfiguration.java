package ro.esolacad.outside;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OutsideConfiguration {

    @Bean
    public String outsideString() {
        return "OUTSIDE";
    }
}
