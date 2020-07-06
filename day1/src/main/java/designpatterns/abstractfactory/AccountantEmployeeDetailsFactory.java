package designpatterns.abstractfactory;

public class AccountantEmployeeDetailsFactory implements EmployeeDetailsFactory {
    @Override
    public EmployeeReview getReview() {
        return new AccountantEmployeeReview();
    }

    @Override
    public EmployeeHistory getHistory() {
        return new AccountantEmployeeHistory();
    }
}
