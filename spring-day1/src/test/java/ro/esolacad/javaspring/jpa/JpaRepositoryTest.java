package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@Sql("/sql/product.sql")
@Sql(value = "/sql/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class JpaRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testRepo() {
        System.out.println(productRepository.findAll());
    }

    @Test
    public void testFindById() {
        Optional<Product> byId = productRepository.findById(1L);
        Assertions.assertTrue(byId.isPresent());

        System.out.println(byId.get());
    }

    @Test
    public void testSaveAll() {
        Product milka = Product.builder()
                .name("Milka")
                .price(BigDecimal.ONE)
                .build();

        Product poiana = Product.builder()
                .name("Poiana")
                .price(BigDecimal.TEN)
                .build();


        productRepository.saveAll(Arrays.asList(milka, poiana));
    }

    @Test
    public void deleteProduct() {
        productRepository.deleteById(-1L);

        boolean present = productRepository.findById(-1L).isPresent();

        Assertions.assertFalse(present);
    }

    @Test
    public void repoMethods() {
        productRepository.count();
        productRepository.existsById(-2L);
    }



}
