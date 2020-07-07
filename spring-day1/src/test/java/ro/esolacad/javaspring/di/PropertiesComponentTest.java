package ro.esolacad.javaspring.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ro.esolacad.javaspring.di.profile.ProfileConfigs;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class PropertiesComponentTest {

    @Autowired
    private PropertiesComponent propertiesComponent;

    @Autowired
    private ProfileConfigs profileConfigs;

    @Test
    public void testConfig() {
        System.out.println(propertiesComponent.getCustomLabel());
        System.out.println(propertiesComponent.getNames());
        System.out.println(propertiesComponent.getResource());
    }

    @Test
    public void testProfileConfigs() {
        profileConfigs.showSomething();
    }
}
