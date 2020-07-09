package ro.esolacad.javaspring.product;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithStockModel {
    private Long id;
    private String name;
    private String code;
    private BigDecimal price;
    private Product.Status status;
    private Long stock;
}
