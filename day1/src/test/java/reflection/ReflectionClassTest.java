package reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import oop.Employee;

public class ReflectionClassTest {

    @Test
    public void testClassClass() {
        Object object = new Employee();
        object.getClass();

        Class<Employee> employeeClass = Employee.class;

        System.out.println(employeeClass.getName());
        System.out.println(employeeClass.getSimpleName());
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] constructors = Employee.class.getConstructors();

        assert constructors.length == 2;

        for(int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];

            System.out.println(constructor.getParameterCount());

            for(int j = 0; j < constructor.getParameterTypes().length; j++) {
                System.out.println(constructor.getParameterTypes()[j].getSimpleName());
            }
            System.out.println();
        }
//        System.out.println(constructors);
    }

    @Test
    public void testFields() {
        Class<Employee> employeeClass = Employee.class;

        for(int i = 0; i < employeeClass.getDeclaredFields().length; i++) {
            System.out.println(employeeClass.getDeclaredFields()[i].getName());
        }

        try {
            Field titleField = employeeClass.getDeclaredField("title");

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
