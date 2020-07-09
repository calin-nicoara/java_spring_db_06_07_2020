package ro.esolacad.javaspring.product;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import ro.esolacad.javaspring.GenericListModel;

//@Controller
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<GenericListModel<ProductModel>> findByAllProducts(
//            @RequestParam(value = "page", required = false, defaultValue = "10") int page,
            @ModelAttribute ProductFilterModel productFilterModel,
            @RequestHeader(value = "username", required = false) String username
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

    @GetMapping("/with-stock/{productId}")
    public ResponseEntity<ProductWithStockModel> findWithStockByProductById(@PathVariable Long productId) {
        return productService.findWithStockByProductById(productId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
//    @PreAuthorize("hasRole('WRITER')")
    public ResponseEntity<ProductModel> saveProduct(@Valid @RequestBody ProductModel product) {
        return ResponseEntity.ok(productService.saveProduct(product));
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
