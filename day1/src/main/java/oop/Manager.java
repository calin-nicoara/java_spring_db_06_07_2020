package oop;

import java.math.BigDecimal;

public class Manager extends Employee {

    private BigDecimal managerBonus;

    public Manager() {}

    public Manager(final String name, final String title, final BigDecimal salary, final BigDecimal managerBonus) {
        super(name, title, salary);
        this.managerBonus = managerBonus;
    }

    public BigDecimal getManagerBonus() {
        return managerBonus;
    }

    public void setManagerBonus(final BigDecimal managerBonus) {
        this.managerBonus = managerBonus;
    }

    public void test() {
        System.out.println(this.protectedString);
    }

    @Override
    public void doDailyDuties() {
        System.out.println("I am a manager. I am doing my job as a:" + this.getTitle());
    }

    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }
}
