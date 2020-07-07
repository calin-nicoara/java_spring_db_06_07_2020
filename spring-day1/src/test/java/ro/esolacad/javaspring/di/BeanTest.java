package ro.esolacad.javaspring.di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestExecutionListeners;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TaxCalculator taxCalculator;

    @Test
    public void useAutowire() {
        BigDecimal taxes = taxCalculator.getTaxes(BigDecimal.valueOf(40));
        Assertions.assertEquals(BigDecimal.valueOf(10).setScale(2), taxes);
    }

    @Test
    public void testTaxCalculator() {
        TaxCalculator taxCalculator = new TaxCalculator("Taxer");

        BigDecimal taxes = taxCalculator.getTaxes(BigDecimal.valueOf(40));
        Assertions.assertEquals(BigDecimal.valueOf(10).setScale(2), taxes);
    }

    @Test
    @Disabled
    public void testGetTaxCalculatorBeanByType() {
        TaxCalculator taxCalculator = applicationContext.getBean(TaxCalculator.class);

        Assertions.assertEquals("Bean", taxCalculator.getName());

        BigDecimal taxes = taxCalculator.getTaxes(BigDecimal.valueOf(40));
        Assertions.assertEquals(BigDecimal.valueOf(10).setScale(2), taxes);
    }

    @Test
    public void testGetTaxCalculatorBeanByName() {
        TaxCalculator taxCalculator = applicationContext.getBean("taxCalculator", TaxCalculator.class);

        Assertions.assertEquals("Bean", taxCalculator.getName());

        BigDecimal taxes = taxCalculator.getTaxes(BigDecimal.valueOf(40));
        Assertions.assertEquals(BigDecimal.valueOf(10).setScale(2), taxes);
    }

    @Test
    public void testGetTaxCalculatorBean2ByName() {
        TaxCalculator taxCalculator = applicationContext.getBean("secondaryBean", TaxCalculator.class);

        Assertions.assertEquals("Bean 2", taxCalculator.getName());

        BigDecimal taxes = taxCalculator.getTaxes(BigDecimal.valueOf(40));
        Assertions.assertEquals(BigDecimal.valueOf(10).setScale(2), taxes);
    }

    @Test
    public void testLifecycle() {
        TaxCalculator taxCalculator = applicationContext.getBean("secondaryBean", TaxCalculator.class);
        taxCalculator.getTaxes(BigDecimal.valueOf(40));

        Assertions.assertEquals(1,taxCalculator.getNumberOfTaxes());

        TaxCalculator secondaryBean = applicationContext.getBean("secondaryBean", TaxCalculator.class);
        Assertions.assertEquals(1, secondaryBean.getNumberOfTaxes());
    }

    @Test
    public void testPrototype() {
        TaxCalculator taxCalculator = applicationContext.getBean("prototypeCalculator", TaxCalculator.class);
        taxCalculator.getTaxes(BigDecimal.valueOf(40));

        Assertions.assertEquals(1,taxCalculator.getNumberOfTaxes());

        TaxCalculator secondaryBean = applicationContext.getBean("prototypeCalculator", TaxCalculator.class);
        Assertions.assertEquals(0, secondaryBean.getNumberOfTaxes());
    }

    @Test
    public void testInjectedString() {
        String bean = applicationContext.getBean("myInjectedString", String.class);

        Assertions.assertEquals("INJECTED", bean);
    }

    @Test
    public void testGetTaxCalculatorBeanByNameWithDep() {
        TaxCalculator taxCalculator = applicationContext.getBean("taxCalculatorWithDep", TaxCalculator.class);

        Assertions.assertEquals("INJECTED", taxCalculator.getName());
    }

    @Test
    public void testOutsideBean() {
        String outsideString = applicationContext.getBean("outsideString", String.class);
        System.out.println(outsideString);
    }
}
