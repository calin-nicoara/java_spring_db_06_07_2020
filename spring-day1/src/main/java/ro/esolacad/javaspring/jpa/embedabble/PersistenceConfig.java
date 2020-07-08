package ro.esolacad.javaspring.jpa.embedabble;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Clock;
import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class PersistenceConfig {

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(Clock.systemUTC().instant());
    }
}
