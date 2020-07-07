package ro.esolacad.javaspring.di;

import java.math.BigDecimal;

public class TaxCalculator {

    private int numberOfTaxes = 0;

    private String name;

    public TaxCalculator(final String name) {
        this.name = name;
    }

    public TaxCalculator() {}


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getNumberOfTaxes() {
        return numberOfTaxes;
    }

    public BigDecimal getTaxes(BigDecimal income) {
        numberOfTaxes += 1;
        return income.multiply(BigDecimal.valueOf(0.25));
    }
}
