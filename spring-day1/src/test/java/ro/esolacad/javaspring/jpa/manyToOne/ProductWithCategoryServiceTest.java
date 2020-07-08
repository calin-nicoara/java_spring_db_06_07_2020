package ro.esolacad.javaspring.jpa.manyToOne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductWithCategoryServiceTest {

    @Autowired
    private ProductWithCategoryService productWithCategoryService;

    @Test
    public void testSave() {
        Category category = Category.builder()
                .name("Bauturi")
                .active(true)
                .build();

        ProductWithCategory product = ProductWithCategory.builder()
                .name("Borsec")
                .price(BigDecimal.ONE)
                .build();

        productWithCategoryService.saveCategoryAndProduct(category,
                product);
    }

}
