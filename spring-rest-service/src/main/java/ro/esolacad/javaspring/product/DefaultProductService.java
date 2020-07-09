package ro.esolacad.javaspring.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import ro.esolacad.javaspring.GenericListModel;
import ro.esolacad.javaspring.UserInterceptor;

@Service
@RequiredArgsConstructor
@Transactional
public class DefaultProductService implements ProductService{

    private final ProductRepository productRepository;

    public GenericListModel<ProductModel> findByAllProducts(final int page, final int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));

        Page<Product> productPage = productRepository.findAll(pageable);

        return toGenericListFromPage(productPage);
    }

    public GenericListModel<ProductModel> findByAllProducts(final ProductFilterModel productFilterModel) {
        Pageable pageable = PageRequest.of(productFilterModel.getPage(), productFilterModel.getSize(), Sort.by("id"));

        Specification<Product> baseSpecification = Specification.where(null);

        if(StringUtils.hasText(productFilterModel.getNameEquals())) {
            Specification<Product> nameSpecification = (Specification<Product>) (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("name"), productFilterModel.getNameEquals());

            baseSpecification = baseSpecification.and(nameSpecification);
        }

        if(productFilterModel.getPriceGreaterThan() != null) {
            Specification<Product> priceSpecification = (Specification<Product>) (root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThan(root.get("price"), productFilterModel.getPriceGreaterThan());

            baseSpecification = baseSpecification.and(priceSpecification);
        }

        System.out.println(UserInterceptor.getUsername());
        Page<Product> productPage = productRepository.findAll(baseSpecification, pageable);
        return toGenericListFromPage(productPage);
    }

    private GenericListModel<ProductModel> toGenericListFromPage(final Page<Product> productPage) {
        List<ProductModel> productModels = productPage
                .stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());

        return GenericListModel.<ProductModel>builder()
                .totalElements(productPage.getTotalElements())
                .totalPages(productPage.getTotalPages())
                .items(productModels)
                .build();
    }

    public Optional<ProductModel> findByProductById(Long productId) {
        return productRepository.findById(productId)
                .map(ProductMapper::toModel);
    }

    public ProductModel saveProduct(ProductModel productModel) {
        Product product = ProductMapper.toEntity(productModel);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toModel(savedProduct);
    }

    public void delete(final Long productId) {
        productRepository.deleteById(productId);
    }

    public void throwError() {
        throw new ProductTestException("Product Test Exception");
    }

    public void throwRuntimeError() {
        throw new RuntimeException("Product Test Exception");
    }
}
