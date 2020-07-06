package stream;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import oop.Employee;

public class StreamTest {

    @Test
    public void testStream() {
        List<Integer> integers = Arrays.asList(122, 45, 64, 23, 12, 23, 32, 78, 23);

        integers.stream()
                .filter(x -> x > 50)
                .peek(x -> System.out.println("After filter:" + x))
                .map(x -> x * 3)
                .map(x -> x / 2)
                .distinct()
                .sorted()
//                .limit(2)
//                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2);

        listOfLists.stream()
                .peek(System.out::println)
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.println("Last result: " + x));
    }

    @Test
    public void testEmployeeStream() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Ionut", "Programator", BigDecimal.valueOf(4000)),
                new Employee("Corina", "Programator", BigDecimal.valueOf(2000)),
                new Employee("Daniel", "analist", BigDecimal.valueOf(3000))
        );

        List<Employee> programatorList = employeeList.stream()
                .filter(x -> x.getTitle().equals("Programator"))
//                .map(x -> {
//                    x.setSalary(x.getSalary().add(BigDecimal.valueOf(200)));
//                    return x;
//                })
                .peek(x -> x.setSalary(x.getSalary().add(BigDecimal.valueOf(200))))
                .collect(Collectors.toList());

        System.out.println(programatorList);

        System.out.println(employeeList);
    }

    @Test
    public void terminatingOperation() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Ionut", "Programator", BigDecimal.valueOf(4000)),
                new Employee("Corina", "Programator", BigDecimal.valueOf(2000)),
                new Employee("Daniel", "Analist", BigDecimal.valueOf(3000))
        );

//        employeeList.stream().collect(Collectors.toSet());

        Map<String, List<Employee>> collect = employeeList.stream()
                .filter(x -> x.getSalary().compareTo(BigDecimal.valueOf(100000)) < 0)
                .peek(x -> x.setSalary(x.getSalary().add(BigDecimal.valueOf(200))))
                .collect(Collectors.groupingBy(employee -> employee.getTitle()));

        System.out.println(collect);
    }

    @Test
    public void reduce() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Ionut", "Programator", BigDecimal.valueOf(4000)),
                new Employee("Corina", "Programator", BigDecimal.valueOf(2000)),
                new Employee("Daniel", "Analist", BigDecimal.valueOf(3000)),
                new Employee("Roxana", "Analist", BigDecimal.valueOf(5000)),
                new Employee("Manole", "Analist", BigDecimal.valueOf(2500))
        );

        BigDecimal analistSalaries = employeeList.stream()
//                .parallel()
                .filter(x -> x.getTitle().equals("Analist"))
                .peek(x -> x.setSalary(x.getSalary().add(BigDecimal.valueOf(1000))))
                .map(x -> x.getSalary())
                .reduce(BigDecimal.ZERO, (accum, currentValue) -> {
                    System.out.println("Accum: " + accum);
                    System.out.println("Current: " + currentValue);
                    return accum.add(currentValue);
                });

        System.out.println(analistSalaries);
    }

    @Test
    public void matchers() {
        Stream.of(1, 2, 3, 4, 5)
                .anyMatch(x -> x < 10);

        Stream.of(1, 2, 3, 4, 5)
                .allMatch(x -> x % 2 == 0);

        Stream.of(1, 2, 3, 4, 5)
                .noneMatch(x -> x % 2 == 0);

        Optional<Integer> first = Stream.of(1, 2, 3, 4, 5)
//                .findAny()
                .findFirst();
    }

}
