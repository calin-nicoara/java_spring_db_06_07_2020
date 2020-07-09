package ro.esolacad.javaspring.product;

import java.util.Optional;

import ro.esolacad.javaspring.GenericListModel;

public interface ProductService {
    GenericListModel<ProductModel> findByAllProducts(final int page, final int size);
    GenericListModel<ProductModel> findByAllProducts(final ProductFilterModel productFilterModel);
    Optional<ProductModel> findByProductById(Long productId);
    ProductModel saveProduct(ProductModel productModel);
    void delete(final Long productId);
    void throwError();
    void throwRuntimeError();
}
