package ro.esolacad.javaspring.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFilterModel {

    private Integer page = 0;
    private Integer size = 10;
    private String nameEquals;
    private BigDecimal priceGreaterThan;
}
