package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JpaCustomRepoTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testPriceGreater() {
        List<Product> byPriceGreaterThan = productRepository.findByPriceGreaterThan(BigDecimal.valueOf(3));

        System.out.println(byPriceGreaterThan);
    }

    @Test
    public void testLike() {
        List<Product> byNameLike = productRepository.findByNameLike("%Cola%");

        System.out.println(byNameLike);
    }
}
