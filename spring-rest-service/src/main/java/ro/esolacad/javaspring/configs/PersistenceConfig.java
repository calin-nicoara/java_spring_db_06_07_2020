package ro.esolacad.javaspring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Clock;
import java.util.Optional;

import ro.esolacad.javaspring.UserInterceptor;

@Configuration
@EnableJpaAuditing
public class PersistenceConfig {

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(Clock.systemUTC().instant());
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.ofNullable(UserInterceptor.getUsername());
    }
}
