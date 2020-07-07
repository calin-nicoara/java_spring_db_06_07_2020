package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testSave() {
        Product product = productService.saveProduct("Parfum", BigDecimal.valueOf(200));

        System.out.println(product);
    }
}
