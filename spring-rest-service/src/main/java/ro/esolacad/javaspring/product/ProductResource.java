package ro.esolacad.javaspring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import ro.esolacad.javaspring.GenericListModel;

//@Controller
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<GenericListModel<ProductModel>> findByAllProducts(
            @ModelAttribute ProductFilterModel productFilterModel,
            @RequestHeader("username") String username
    ) {
        System.out.println("Username:" + username);

        return ResponseEntity.ok(productService.findByAllProducts(productFilterModel.getPage(),
                productFilterModel.getSize()));
    }

    @GetMapping("/filter")
    public ResponseEntity<GenericListModel<ProductModel>> findByAllProductsFilter(
            @ModelAttribute ProductFilterModel productFilterModel) {
        return ResponseEntity.ok(productService.findByAllProducts(productFilterModel));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> findByProductById(@PathVariable Long productId) {
        return productService.findByProductById(productId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public void saveProduct(@Valid @RequestBody ProductModel product) {
        productService.saveProduct(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable("productId") Long productId,
                              @Valid @RequestBody ProductModel product,
                              BindingResult bindingResult) {
        System.out.println(bindingResult.getAllErrors());

        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        product.setId(productId);
        productService.saveProduct(product);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.delete(productId);
    }

    @GetMapping("/error")
    public void throwError() {
        productService.throwError();
    }

    @GetMapping("/runtimeError")
    public void runtimeError() {
        productService.throwRuntimeError();
    }
}
