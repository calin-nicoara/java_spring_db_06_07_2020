package ro.esolacad.javaspring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FinanceComponent {

//    @Autowired
    private final TaxCalculatorComponent taxCalculatorComponent;
    private final InvoiceFileWriter invoiceFileWriter;
//    private BigDecimal bigDecimal;
//
//    @Autowired
//    public void setTaxCalculatorComponent(TaxCalculatorComponent taxCalculatorComponent) {
//        this.taxCalculatorComponent = taxCalculatorComponent;
//    }

//    @Autowired
    public FinanceComponent(final TaxCalculatorComponent taxCalculatorComponent,
                            final InvoiceFileWriter invoiceFileWriter) {
        this.taxCalculatorComponent = taxCalculatorComponent;
        this.invoiceFileWriter = invoiceFileWriter;
    }

//    @Autowired(required = false)
//    public void setBigDecimal(final BigDecimal bigDecimal) {
//        this.bigDecimal = bigDecimal;
//    }


    public void calculateFinances(BigDecimal income) {
        System.out.println("Calculating finances");
        System.out.println(taxCalculatorComponent.getTaxes(income));

        invoiceFileWriter.writeInvoice(income);
    }

}
