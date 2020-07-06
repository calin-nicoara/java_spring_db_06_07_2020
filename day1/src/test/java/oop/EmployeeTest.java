package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void test() {
        Employee employee = new Employee("Ionut", "Programator", BigDecimal.valueOf(4));

        employee.doDailyDuties();
    }

}
