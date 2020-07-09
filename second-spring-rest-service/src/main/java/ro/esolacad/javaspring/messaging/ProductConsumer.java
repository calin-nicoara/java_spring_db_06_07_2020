package ro.esolacad.javaspring.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

    @StreamListener("productChannel")
    public void consumeProduct(final Message<ProductModel> message) {
        System.out.println("------------------------");
        System.out.println("Received product:" + message.getPayload());
        System.out.println("------------------------");
    }
}
