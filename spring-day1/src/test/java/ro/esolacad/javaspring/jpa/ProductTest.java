package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void test() {
        Product product = Product.builder()
                .id(1L)
                .name("Nume")
                .price(BigDecimal.ONE)
                .build();
    }

}
