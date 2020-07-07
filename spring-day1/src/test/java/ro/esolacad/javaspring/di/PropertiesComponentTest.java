package ro.esolacad.javaspring.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertiesComponentTest {

    @Autowired
    private PropertiesComponent propertiesComponent;

    @Test
    public void testConfig() {
        System.out.println(propertiesComponent.getCustomLabel());
        System.out.println(propertiesComponent.getNames());
        System.out.println(propertiesComponent.getResource());
    }
}
