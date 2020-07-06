package oop;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee implements Payable, Taxable{

    private String name;
    private String title;
    private BigDecimal salary;
    protected String protectedString;

    public Employee() {}

    public Employee(final String name, final String title, final BigDecimal salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    public void doDailyDuties() {
        System.out.println("I am an employee. I am doing my job as a:" + this.title);
    }

    @Override
    public void giveARaise(final BigDecimal raise) {
        this.salary = this.salary.add(raise);
    }

    @Override
    public void payTaxes(final BigDecimal taxes) {
        System.out.println("Payed taxes " + taxes);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", protectedString='" + protectedString + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(title, employee.title) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(protectedString, employee.protectedString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, salary, protectedString);
    }
}
