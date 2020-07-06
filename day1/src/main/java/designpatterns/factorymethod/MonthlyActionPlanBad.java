package designpatterns.factorymethod;


import java.math.BigDecimal;


public class MonthlyActionPlanBad {

    public void doMonthlyActivities() {
        EmployeeBad employee = new EmployeeBad("Mark");

        System.out.println("I am: " + employee.getName());

        employee.doJob();
        employee.paySalary(BigDecimal.valueOf(3500));
    }
}
