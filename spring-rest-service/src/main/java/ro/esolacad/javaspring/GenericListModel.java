package ro.esolacad.javaspring;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolacad.javaspring.product.Product;
import ro.esolacad.javaspring.product.ProductModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericListModel<T> {

    private List<T> items;
    private long totalElements;
    private int totalPages;
}
