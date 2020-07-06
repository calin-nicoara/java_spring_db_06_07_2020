package designpatterns;

import org.junit.jupiter.api.Test;

import designpatterns.abstractfactory.AccountantEmployeeDetailsFactory;
import designpatterns.abstractfactory.EmployeeDetailsFactory;
import designpatterns.abstractfactory.EmployeeHistory;
import designpatterns.abstractfactory.EmployeeReview;

public class AbstractFactoryTest {

    @Test
    public void abstractFactory() {
        EmployeeDetailsFactory employeeDetailsFactory = new AccountantEmployeeDetailsFactory();

        EmployeeHistory history = employeeDetailsFactory.getHistory();

        assert history.getYearsEmployed() == 5;

        EmployeeReview review = employeeDetailsFactory.getReview();

        assert review.getScore() == 3;
    }
}
