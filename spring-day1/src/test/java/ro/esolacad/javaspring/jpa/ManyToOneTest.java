package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import ro.esolacad.javaspring.jpa.manyToOne.Category;
import ro.esolacad.javaspring.jpa.manyToOne.CategoryRepository;
import ro.esolacad.javaspring.jpa.manyToOne.ProductWithCategory;
import ro.esolacad.javaspring.jpa.manyToOne.ProductWithCategoryRepository;

@SpringBootTest
public class ManyToOneTest {

    @Autowired
    private ProductWithCategoryRepository productWithCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveProductAndCategory() {
        Category category = Category.builder()
                .name("Bauturi")
                .active(true)
                .build();

        Category savedCategory = categoryRepository.save(category);

        ProductWithCategory product = ProductWithCategory.builder()
                .name("Borsec")
                .price(BigDecimal.ONE)
                .category(Category.builder().id(1L).build())
//                .category(savedCategory)
                .build();

        ProductWithCategory productWithCategory = productWithCategoryRepository.save(product);

        System.out.println("AFter product is saved");

        Optional<ProductWithCategory> byId = productWithCategoryRepository.findById(productWithCategory.getId());
        System.out.println(byId);
//        System.out.println(byId.get().getCategory());
    }
}
