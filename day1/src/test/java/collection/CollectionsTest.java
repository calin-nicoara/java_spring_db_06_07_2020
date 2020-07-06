package collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import oop.Employee;
import oop.Manager;

public class CollectionsTest {

    @Test
    public void testList() {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(2);
        integerList.add(3);
        integerList.add(3);

        System.out.println(integerList);

        Integer integer = integerList.get(2);

        assert integer == 3;
    }

    @Test
    public void testSet() {
        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(2);
        integerSet.add(2);
        integerSet.add(3);

//        System.out.println(integerSet);

        for(Integer number: integerSet) {
            System.out.println(number);
        }

    }

    @Test
    public void testEmployeeSet() {
        Set<Employee> employeeSet = new HashSet<>();

        Employee employee = new Employee();
        employee.setName("Mihaela");

//        Employee employee2 = new Employee();
//        employee2.setName("Mihaela");

        employeeSet.add(employee);
        System.out.println(employee.hashCode());
        employee.setTitle("Secretara");
        System.out.println(employee.hashCode());
        employeeSet.add(employee);

        System.out.println(employeeSet);
    }

    @Test
    public void testGeneric() {
        List<? extends Employee> employeeList = new ArrayList<Manager>();
    }

    @Test
    public void testMap() {
        Map<Integer, String> namesByIdNumbers = new HashMap<>();

        namesByIdNumbers.put(1, "Andrei");
        namesByIdNumbers.put(2, "Daniela");

        assert namesByIdNumbers.get(1).equals("Andrei");

        System.out.println(namesByIdNumbers.keySet());

        namesByIdNumbers.put(1, "Marius");

        assert namesByIdNumbers.get(1).equals("Marius");

        namesByIdNumbers.put(null, "Null");

        assert namesByIdNumbers.get(null).equals("Null");
    }

    @Test
    public void testCollections() {
        List<String> stringList = Arrays.asList(
                "Bucuresti",
                "Cluj",
                "Iasi"
        );

        Collections.shuffle(stringList);

        System.out.println(stringList);

        List<String> stringList2 = Collections.singletonList("SINGLETON");

        System.out.println(stringList2);
    }
}
