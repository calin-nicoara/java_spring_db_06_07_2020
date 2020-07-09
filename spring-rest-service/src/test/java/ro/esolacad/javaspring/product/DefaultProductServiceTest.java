package ro.esolacad.javaspring.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class DefaultProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private DefaultProductService defaultProductService;

    @Test
    public void testGetProduct() {
        Long productId = 1L;

        Product productFromDb = getTestProduct(productId);

        Mockito.when(productRepository.findById(productId))
                .thenReturn(Optional.of(productFromDb));

        ProductModel expectedProductModel = getTestProductModel(productId);

        Optional<ProductModel> actualProductModelOptional = defaultProductService.findByProductById(productId);

        Assertions.assertTrue(actualProductModelOptional.isPresent());
        Assertions.assertEquals(expectedProductModel, actualProductModelOptional.get());
    }

    @Test
    public void testSaveProduct() {
        defaultProductService.saveProduct(getTestProductModel(null));

        Mockito.verify(productRepository).save(getTestProduct(null));

        Mockito.verifyNoMoreInteractions(productRepository);
    }

    private Product getTestProduct(final Long productId) {
        return Product.builder()
                .id(productId)
                .name("Coca-Cola")
                .price(BigDecimal.ONE)
                .status(Product.Status.ACTIVE)
                .build();
    }

    private ProductModel getTestProductModel(Long productId) {
        return ProductModel.builder()
                .id(productId)
                .name("Coca-Cola")
                .price(BigDecimal.ONE)
                .status(Product.Status.ACTIVE)
                .build();
    }
}
