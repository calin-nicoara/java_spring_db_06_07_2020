package designpatterns.abstractfactory;

public interface EmployeeDetailsFactory {
    EmployeeReview getReview();
    EmployeeHistory getHistory();
}
