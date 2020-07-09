package ro.esolacad.javaspring.product.externalclients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StockFeignClientFallBack implements StockFeignClient{
    @Override
    public ResponseEntity<StockModel> findStock(final String productCode) {
        System.out.println("USED FALLBACK!");

        return ResponseEntity.ok(StockModel.builder()
                .productCode(productCode)
                .stock(0L)
                .build()
        );
    }
}
