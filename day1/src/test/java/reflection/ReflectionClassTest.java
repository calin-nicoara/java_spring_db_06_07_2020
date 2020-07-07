package reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Employee employee = new Employee("Ionut", "Manager", BigDecimal.valueOf(3));

        Class<Employee> employeeClass = Employee.class;

//        for(int i = 0; i < employeeClass.getDeclaredFields().length; i++) {
//            System.out.println(employeeClass.getDeclaredFields()[i].getName());
//        }

        try {
            Field titleField = employeeClass.getDeclaredField("title");
//            Field titleField = employeeClass.getField("title");

            titleField.setAccessible(true);
            System.out.println("Current value: " + (String) titleField.get(employee));

            titleField.set(employee, "Reflection specialist");

            System.out.println("New value:" + employee.getTitle());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMethod() {
        Employee employee = new Employee("Ionut", "Manager", BigDecimal.valueOf(3));

        Class<?> aClass = employee.getClass();

        try {
            Method getName = aClass.getMethod("getName");

            Object nameValue = getName.invoke(employee);

            System.out.println(nameValue);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetMethod() {
        Employee employee = new Employee("Ionut", "Manager", BigDecimal.valueOf(3));

        Class<?> aClass = employee.getClass();

        try {
            Method getName = aClass.getMethod("setName", String.class);

            getName.invoke(employee, "Reflection Ionut");

            System.out.println(employee.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMethodsTest() {
        Employee employee = new Employee("Ionut", "Manager", BigDecimal.valueOf(3));

        Class<?> aClass = employee.getClass();

        Arrays.stream(aClass.getMethods())
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .filter(method -> method.getParameterCount() == 0)
                .filter(method ->  method.getReturnType() != Void.class);
    }

    @Test
    public void testListProxy() {
        List<Integer> listToProxy = new ArrayList<>();
        listToProxy.add(1);
        listToProxy.add(2);
        listToProxy.add(3);


        List proxyList = (List) Proxy.newProxyInstance(List.class.getClassLoader(),
                new Class[]{List.class}, (proxy, method, args) -> {
                    System.out.println("Method to use: " + method.getName());
                    System.out.println("Before method call");
                    Object invoke = method.invoke(listToProxy, args);
                    System.out.println("After method call");
                    return invoke;
                });

        proxyList.add(5);

        System.out.println(proxyList);
    }


}

