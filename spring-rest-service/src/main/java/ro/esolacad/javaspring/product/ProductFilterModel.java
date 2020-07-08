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

    private Integer page;
    private Integer size;
    private String nameEquals;
    private BigDecimal priceGreaterThan;
}
