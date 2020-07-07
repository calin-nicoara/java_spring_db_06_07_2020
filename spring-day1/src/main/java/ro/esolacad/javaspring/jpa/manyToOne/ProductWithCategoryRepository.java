package ro.esolacad.javaspring.jpa.manyToOne;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductWithCategoryRepository extends JpaRepository<ProductWithCategory, Long> {
}
