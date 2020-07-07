package ro.esolacad.javaspring.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(String name, BigDecimal price) {
        Product newProduct = Product.builder()
                .name(name)
                .price(price)
                .build();

        return productRepository.save(newProduct);
    }

    public Page<Product> findAllProducts(int pageNumber, int pageSize){

//        Sort.by(Sort.Order.asc("id"), Sort.Order.desc("price"))
//        Sort.by("id", "price");
//        Sort.by(Sort.Direction.DESC, "id", "price");

        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(Sort.Direction.DESC, "id"));

        return productRepository.findAll(pageable);
    }
}
