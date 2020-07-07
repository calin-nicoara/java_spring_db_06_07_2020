package ro.esolacad.javaspring.di;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("csvFileWriter")
//@Primary
@ConditionalOnProperty(prefix = "flags", value = "invoice-writer.type", havingValue = "csv")
public class CsvFileWriter implements InvoiceFileWriter{

    @Override
    public void writeInvoice(final BigDecimal income) {
        System.out.println("Write csv invoice file: " + income);
    }
}
