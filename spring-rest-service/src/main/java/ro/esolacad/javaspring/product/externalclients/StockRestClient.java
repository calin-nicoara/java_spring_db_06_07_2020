package ro.esolacad.javaspring.product.externalclients;

public interface StockRestClient {

    StockModel getStockModel(String productCode);
    StockModel getStockModelFromFeign(String productCode);
}
