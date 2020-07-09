package ro.esolacad.javaspring.product.externalclients;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockModel {
    private String productCode;
    private Long stock;
}
