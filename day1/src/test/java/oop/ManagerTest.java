package oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void test() {
        Manager manager = new Manager();
        manager.setTitle("District Manager");

        manager.setName("Bogdan");

        assert manager.getName().equals("Bogdan");

        manager.doDailyDuties();
    }

    @Test
    public void useInheritance() {
        Manager manager = new Manager();
        manager.setTitle("District Manager");

        Employee employee = manager;

        employee.doDailyDuties();
    }

    @Test
    public void testObject() {
        Employee employee = new Employee();
    }

}
