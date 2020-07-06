package designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public abstract class LineParser {

    public final List<String> getLines(String filePath) {
        List<String> headers = getHeaders();

        // more code
        // open file
        // process file
        // hard to duplicate

        return getRows(headers);
    }

    protected List<String> getRows(final List<String> headers) {
        return Arrays.asList("DEfault Row 1");
    }

    protected abstract List<String> getHeaders();
}
