package ro.esolacad.javaspring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;

@Configuration
public class BeanConfig {

    @Bean
    public TaxCalculator taxCalculator() {
        return new TaxCalculator("Bean");
    }

    @Bean("secondaryBean")
    public TaxCalculator taxCalculator2() {
        System.out.println();
        System.out.println();
        System.out.println("Created seconday bean!");
        System.out.println();
        System.out.println();
        return new TaxCalculator("Bean 2");
    }

    @Bean
    @Scope("prototype")
    public TaxCalculator prototypeCalculator() {
        return new TaxCalculator("PrototypeBean");
    }

    @Bean
    public TaxCalculator taxCalculatorWithDep(@Qualifier("myInjectedString") String injectedString) {
        return new TaxCalculator(injectedString);
    }

    @Bean
    public String myInjectedString() {
        return "INJECTED";
    }

    @Bean
    public String mySecondInjectedString() {
        return "SECOND_INJECTED";
    }
}
