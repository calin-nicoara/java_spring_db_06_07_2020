package ro.esolacad.javaspring.product.messaging;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.kafka.support.KafkaHeaders;

import ro.esolacad.javaspring.product.ProductModel;

@MessagingGateway
public interface ProductGateway {

    @Gateway(requestChannel = "productChannel",
    headers = {@GatewayHeader(name = KafkaHeaders.MESSAGE_KEY, expression = "#args[0].code")})
    void sendProduct(ProductModel productModel);
}
