package designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public class CsvLineParser extends LineParser{

    protected List<String> getRows(final List<String> headers) {
        return Arrays.asList("Csv Row 1", "Csv Row 2");
    }

    protected List<String> getHeaders() {
        return Arrays.asList("Csv 1", "Csv 2");
    }
}
