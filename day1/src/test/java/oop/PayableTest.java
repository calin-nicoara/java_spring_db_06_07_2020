package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PayableTest {

    @Test
    public void polymorphism() {
        Employee employee = new Employee();
        employee.setSalary(BigDecimal.ZERO);

        Payable payable = employee;
        payable.giveARaise(BigDecimal.ONE);

        assert employee.getSalary().equals(BigDecimal.ONE);

        Taxable taxable = employee;
        taxable.payTaxes(BigDecimal.TEN);
    }

}
