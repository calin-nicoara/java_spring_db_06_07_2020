package ro.esolacad.javaspring.stock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockResource {

    @GetMapping("/stock/{productCode}")
    public ResponseEntity<StockModel> test(@PathVariable("productCode") String code) {
        StockModel stockModel = StockModel.builder()
                .productCode(code)
                .stock(5L)
                .build();

        return ResponseEntity.ok(stockModel);
    }
}
