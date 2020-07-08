package ro.esolacad.javaspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ro.esolacad.javaspring.product.ProductTestException;

@RestControllerAdvice
public class ControllerGeneralAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> returnErrorMessage(RuntimeException re) {
        re.printStackTrace();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Sorry! My fault runtime!");
    }

    @ExceptionHandler(ProductTestException.class)
    public ResponseEntity<String> returnErrorMessage(ProductTestException re) {
        re.printStackTrace();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Sorry! My fault!");
    }
}
