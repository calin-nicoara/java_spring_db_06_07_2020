package ro.esolacad.javaspring.product;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {
    private Long id;

//    @NotNull
//    @NotEmpty
    @NotBlank
    private String name;

    private String code;

    @DecimalMin("1.00")
    private BigDecimal price;

    private Product.Status status;
}
