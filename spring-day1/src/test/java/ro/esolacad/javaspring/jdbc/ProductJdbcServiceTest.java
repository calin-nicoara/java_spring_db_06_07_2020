package ro.esolacad.javaspring.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql("/sql/product.sql")
@Sql(value = "/sql/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ProductJdbcServiceTest {

    @Autowired
    private ProductJdbcService productJdbcService;

    @Test
    public void testJdbcGet() {
        System.out.println(productJdbcService.getNumberOfProducts());
    }

    @Test
    public void testGetProduct() {
        ProductJdbc productById = productJdbcService.findProductById(-3L);

        System.out.println(productById);
    }

    @Test
    public void testSaveProduct() {
        ProductJdbc productJdbc = new ProductJdbc();
        productJdbc.setId(100L);
        productJdbc.setName("Dero");
        productJdbc.setPrice(BigDecimal.valueOf(20));

        productJdbcService.saveProduct(productJdbc);

        System.out.println(productJdbcService.findProductById(100L));
    }

    @Test
    public void testSaveProductNamed() {
        ProductJdbc productJdbc = new ProductJdbc();
        productJdbc.setId(100L);
        productJdbc.setName("Dero");
        productJdbc.setPrice(BigDecimal.valueOf(20));

        productJdbcService.saveProductWithNamed(productJdbc);

        System.out.println(productJdbcService.findProductById(100L));
    }

    @Test
    public void testGetAllProducts() {
        System.out.println(productJdbcService.findAllProduct());
    }
}
