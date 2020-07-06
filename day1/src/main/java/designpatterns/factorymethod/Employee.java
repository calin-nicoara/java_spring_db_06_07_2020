package designpatterns.factorymethod;

import java.math.BigDecimal;

public interface Employee {
    void doJob();
    void paySalary(BigDecimal salary);
    String getName();
}
