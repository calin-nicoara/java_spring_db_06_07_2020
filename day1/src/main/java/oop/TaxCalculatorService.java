package oop;

import java.math.BigDecimal;

public class TaxCalculatorService {

    private BigDecimal yearlyIncome;
    private BigDecimal taxPercentage;

    public BigDecimal calculateAnnualTaxes(Employee employee) {
        getExternalRevenues();
        checkLastYearEarnings();

        return BigDecimal.TEN;
    }

    private void checkLastYearEarnings() {

    }

    private void getExternalRevenues() {

    }

}
