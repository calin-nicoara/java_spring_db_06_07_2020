package designpatterns.factorymethod;

import java.math.BigDecimal;

public class Accountant implements Employee{
    private String name;
    private BigDecimal currentMoney = new BigDecimal(0);

    public Accountant(final String name) {
        this.name = name;
    }

    public void doJob() {
        System.out.println("I am an Accoutant and am doing my job");
    }

    public void paySalary(BigDecimal salary) {
        System.out.println("Salary payed: " + salary);
        currentMoney = currentMoney.add(salary);
    }

    public String getName() {
        return name;
    }
}
