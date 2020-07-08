package ro.esolacad.javaspring.jpa.manyToOne;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductWithCategoryService {

    private final ProductWithCategoryRepository productWithCategoryRepository;
    private final CategoryRepository categoryRepository;

    public void saveCategoryAndProduct(Category category, ProductWithCategory productWithCategory) {
        Category savedCategory = categoryRepository.save(category);

//        if(true) {
//            throw new RuntimeException();
//        }
        productWithCategory.setCategory(savedCategory);
        productWithCategoryRepository.save(productWithCategory);
    }
}
