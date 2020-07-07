package ro.esolacad.javaspring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;


@Component
public class PropertiesComponent {

    @PostConstruct
    public void init() {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Created PropertiesComponent");
        System.out.println("Custom label: " + customLabel);
        System.out.println("Names: " + names);
        System.out.println("--------------------------------------");
        System.out.println();
    }

    @Value("${custom-label}")
    private String customLabel;

    @Value("${names}")
    private Set<String> names;

    @Value("classpath:test-resource")
    private Resource resource;

    public String getCustomLabel() {
        return customLabel;
    }

    public Set<String> getNames() {
        return names;
    }

    public Resource getResource() {
        return resource;
    }
}
