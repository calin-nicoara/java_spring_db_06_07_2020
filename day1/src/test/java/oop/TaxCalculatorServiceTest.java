package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorServiceTest {

    @Test
    public void calculate() {
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

        assert taxCalculatorService.calculateAnnualTaxes(new Manager()).equals(BigDecimal.TEN);
        assert taxCalculatorService.calculateAnnualTaxes(new Employee()).equals(BigDecimal.TEN);
    }
}
