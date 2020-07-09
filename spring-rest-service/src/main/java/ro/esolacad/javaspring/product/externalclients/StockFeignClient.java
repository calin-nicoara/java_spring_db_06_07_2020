package ro.esolacad.javaspring.product.externalclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name ="stock-service", url = "http://localhost:8081",
        fallback = StockFeignClientFallBack.class)
public interface StockFeignClient {

    @RequestMapping(value = "/stock/{productCode}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StockModel> findStock(@PathVariable("productCode") String productCode);
}
