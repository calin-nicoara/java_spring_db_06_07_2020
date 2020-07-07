package ro.esolacad.javaspring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("select p from Product p where p.price > ?1")
//    @Query(value = "", nativeQuery = true)

//    @Query("select p from Product p where p.price > :price")
    List<Product> findByPriceGreaterThan(@Param("price") BigDecimal price);

    List<Product> findByNameLike(String nameLike);

//    List<Product> findByIdIsGreaterThanAndNameContainsAndPrice

//    Optional<Product> findByNameLike(String nameLike);
}
