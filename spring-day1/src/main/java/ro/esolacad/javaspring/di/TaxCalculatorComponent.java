package ro.esolacad.javaspring.di;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TaxCalculatorComponent {

//    @PostConstruct
    public void init() {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Created TaxCalculatorComponent");
        System.out.println("--------------------------------------");
        System.out.println();
    }

    public BigDecimal getTaxes(BigDecimal income) {
        return income.multiply(BigDecimal.valueOf(0.25));
    }

//    @PreDestroy
    public void destroy() {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Destroyed TaxCalculatorComponent");
        System.out.println("--------------------------------------");
        System.out.println();
    }
}
