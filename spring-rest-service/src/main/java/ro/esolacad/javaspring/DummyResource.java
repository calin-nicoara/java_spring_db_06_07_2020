package ro.esolacad.javaspring;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.esolacad.javaspring.product.ProductModel;

@RestController
@RequestMapping("/dummy")
public class DummyResource {

    @GetMapping("/open")
    public ResponseEntity<String> testOpen() {
        return ResponseEntity.ok("Open for business!");
    }

    @GetMapping("/closed")
    public ResponseEntity<String> testClosed() {
        SecurityContext context = SecurityContextHolder.getContext();
        Object principal = context.getAuthentication().getPrincipal();

        System.out.println("PRINCIPAL: " + principal);

        return ResponseEntity.ok("Open only for regular customers!");
    }
}
