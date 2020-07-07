package ro.esolacad.javaspring.di;

import java.math.BigDecimal;

public interface InvoiceFileWriter {
    void writeInvoice(final BigDecimal income);
}
