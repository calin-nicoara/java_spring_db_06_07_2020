package ro.esolacad.javaspring.di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ComponentTest {

    @Autowired
    private TaxCalculatorComponent taxCalculatorComponent;

    @Autowired
    private FinanceComponent financeComponent;

    @Autowired
    private LazyComponent lazyComponent;

    @Test
    public void testComponent() {
        BigDecimal taxes = taxCalculatorComponent.getTaxes(BigDecimal.valueOf(40));
        Assertions.assertEquals(BigDecimal.valueOf(10).setScale(2), taxes);
    }

    @Test
    public void testFinanceComponent() {
        financeComponent.calculateFinances(BigDecimal.TEN);
    }
}
