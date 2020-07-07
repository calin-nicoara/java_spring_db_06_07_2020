package ro.esolacad.javaspring.di;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("excelFileWriter")
@ConditionalOnProperty(prefix = "flags", value = "invoice-writer.type", havingValue = "excel")
public class ExcelFileWriter implements InvoiceFileWriter {

    @Override
    public void writeInvoice(final BigDecimal income) {
        System.out.println("Write excel invoice file: " + income);
    }
}
