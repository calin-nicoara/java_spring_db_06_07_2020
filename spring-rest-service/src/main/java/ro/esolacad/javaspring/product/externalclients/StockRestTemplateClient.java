package ro.esolacad.javaspring.product.externalclients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StockRestTemplateClient implements StockRestClient{

    private final StockFeignClient stockFeignClient;

    @Override
    public StockModel getStockModel(final String productCode) {
        String urlToStock = "http://localhost:8081/stock/" + productCode;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<StockModel> forEntity = restTemplate.getForEntity(urlToStock, StockModel.class);

        return forEntity.getBody();
    }

    @Override
    public StockModel getStockModelFromFeign(final String productCode) {
        return stockFeignClient.findStock(productCode).getBody();
    }


}
