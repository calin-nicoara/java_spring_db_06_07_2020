package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
public class JpaPaginationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void paginationTest() {
        Page<Product> allProducts = productService.findAllProducts(1, 2);

        System.out.println(allProducts.getTotalElements());
        System.out.println(allProducts.getTotalPages());

        System.out.println(allProducts.getContent());
    }
}
