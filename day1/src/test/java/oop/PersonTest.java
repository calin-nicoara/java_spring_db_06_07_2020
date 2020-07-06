package oop;

import org.junit.jupiter.api.Test;


public class PersonTest {

    @Test
    public void testPerson() {
        Person person = new Person();

        person.setName("Ionut");

        assert person.getName().equals("Ionut");
    }
}
