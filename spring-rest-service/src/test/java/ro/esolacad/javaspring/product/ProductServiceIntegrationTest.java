package ro.esolacad.javaspring.product;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.Arrays;

import ro.esolacad.javaspring.GenericListModel;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ProductResource.class)
public class ProductServiceIntegrationTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAllProducts() throws Exception {
        GenericListModel<ProductModel> genericListModel = GenericListModel.<ProductModel>builder()
                .totalElements(5)
                .totalPages(0)
                .items(Arrays.asList(getTestProductModel(null)))
                .build();

        Mockito.when(productService.findByAllProducts(0, 10))
                .thenReturn(genericListModel);

        MvcResult mvcResult = mockMvc.perform(
                get("/api/product")
                .with(user("admin").password("admin").roles("ADMIN"))
        )
                .andExpect(status().isOk())
                .andReturn();

        String actualResult = mvcResult.getResponse().getContentAsString();

        String expectedResult = objectMapper.writeValueAsString(genericListModel);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    private ProductModel getTestProductModel(Long productId) {
        return ProductModel.builder()
                .id(productId)
                .name("Coca-Cola")
                .price(BigDecimal.ONE)
                .status(Product.Status.ACTIVE)
                .build();
    }
}
