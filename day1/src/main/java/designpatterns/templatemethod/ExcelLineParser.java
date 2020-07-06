package designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public class ExcelLineParser extends LineParser{

    @Override
    protected List<String> getRows(final List<String> headers) {
        return Arrays.asList("Excel Row 1", "Excel Row 2");
    }

    @Override
    protected List<String> getHeaders() {
        return Arrays.asList("Excel 1", "Excel 2");
    }
}
