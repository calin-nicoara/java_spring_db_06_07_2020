package ro.esolacad.javaspring.product;

public class ProductMapper {

    public static Product toEntity(final ProductModel productModel) {
        return Product.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .price(productModel.getPrice())
                .status(productModel.getStatus())
                .build();
    }

    public static ProductModel toModel(final Product product) {
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }
}
