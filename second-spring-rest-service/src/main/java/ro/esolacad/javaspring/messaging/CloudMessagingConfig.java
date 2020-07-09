package ro.esolacad.javaspring.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(MessagingChannels.class)
public class CloudMessagingConfig {
}
