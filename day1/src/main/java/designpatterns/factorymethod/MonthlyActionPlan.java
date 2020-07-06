package designpatterns.factorymethod;

import java.math.BigDecimal;

public abstract class MonthlyActionPlan {

    public void doMonthlyActivities() {
        Employee employee = getEmployeeInstance();

        System.out.println("I am: " + employee.getName());

        employee.doJob();
        employee.paySalary(BigDecimal.valueOf(3500));
    }

    protected abstract Employee getEmployeeInstance();
}
