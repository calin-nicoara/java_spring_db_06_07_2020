package lambdas;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import oop.Employee;
import oop.Manager;

import static org.junit.jupiter.api.Assertions.*;

class LambdasTest {

    @Test
    public void testLambdas() {
        NumberComputer numberComputer = (int p1,int p2) -> {
            int a = p1 + p2;
            System.out.println(a);
            return a;
        };

        NumberComputer numberComputer2 = (p1, p2) -> p1 + p2;

//        assert numberComputer.calculate(2,5) == 7;

        NoParamMethod noParamMethod = () -> System.out.println("hello");

        noParamMethod.noParam();
    }

    @Test
    public void testExistingFunctionalInterfaces() {
        Consumer<String> toUpperCaseShower = string -> System.out.println(string.toUpperCase());
        toUpperCaseShower.accept("hello");

        Supplier<Employee> employeeSupplier = () -> {
            System.out.println("SUPPLIER RUN");
            Employee employee = new Employee();
            employee.setName("Maria");
            return employee;
        };

        System.out.println(employeeSupplier.get());

        Function<Employee, Manager> promoter = employee -> {
            Manager manager = new Manager();
            manager.setTitle(employee.getTitle());
            manager.setName(employee.getName());
            return manager;
        };

        Manager manager = promoter.apply(new Employee());

        System.out.println(manager);

        Predicate<Employee> hasSalaryGreaterThan1000 = employee -> employee.getSalary()
                .compareTo(BigDecimal.valueOf(1000)) > 0;

        Employee salaryMan = new Employee();
        salaryMan.setSalary(BigDecimal.valueOf(1500));
        assert hasSalaryGreaterThan1000.test(salaryMan);
    }

    @Test
    public void methodReference() {
        Consumer<String> stringConsumer = System.out::println;

        MultiParamLambdaBusiness multiParamLambdaBusiness = new MultiParamLambdaBusiness();
        MultiParamLambdas multiParamLambdas = multiParamLambdaBusiness::calculateEverything;
    }

}
