package designpatterns.factorymethod;

public class AccoutantMonthlyActionPlan extends MonthlyActionPlan{

    @Override
    protected Employee getEmployeeInstance() {
        return new Accountant("Accountant Jerry");
    }
}
