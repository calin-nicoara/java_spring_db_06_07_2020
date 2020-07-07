package ro.esolacad.javaspring.jpa.manyToOne;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
