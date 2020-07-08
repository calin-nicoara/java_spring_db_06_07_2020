package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql("/sql/product.sql")
@Sql(value = "/sql/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class JpaPaginationTest {

    @Autowired
    private ProductService productService;

    @Test
    @Sql("/sql/one_product.sql")
    @Sql(value = "/sql/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void paginationTest() {
//        Page<Product> allProducts = productService.findAllProducts(1, 2);
        Page<Product> allProducts = productService.findAllProducts(0, 2);

        System.out.println(allProducts.getTotalElements());
        System.out.println(allProducts.getTotalPages());

        System.out.println(allProducts.getContent());
    }
}
