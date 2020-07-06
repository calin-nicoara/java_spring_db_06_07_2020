package designpatterns.abstractfactory;

public class AccountantEmployeeHistory implements EmployeeHistory {
    @Override
    public int getYearsEmployed() {
        return 5;
    }
}
