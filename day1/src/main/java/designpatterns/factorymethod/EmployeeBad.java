package designpatterns.factorymethod;

import java.math.BigDecimal;

public class EmployeeBad {
    private String name;
    private BigDecimal currentMoney = new BigDecimal(0);

    public EmployeeBad(final String name) {
        this.name = name;
    }

    public void doJob() {
        System.out.println("I am an employee and am doing my job");
    }

    public void paySalary(BigDecimal salary) {
        System.out.println("Salary payed: " + salary);
        currentMoney = currentMoney.add(salary);
    }

    public String getName() {
        return name;
    }
}
