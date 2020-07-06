package designpatterns.abstractfactory;

public class AccountantEmployeeReview implements EmployeeReview {
    @Override
    public int getScore() {
        return 3;
    }
}
