package designpatterns;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import designpatterns.templatemethod.CsvLineParser;
import designpatterns.templatemethod.ExcelLineParser;
import designpatterns.templatemethod.LineParser;

public class TemplateMethodTest {

    @Test
    public void csvLineParser() {
        LineParser lineParser = new CsvLineParser();

        System.out.println(lineParser.getLines("test"));
    }

    @Test
    public void excelLineParser() {
        LineParser lineParser = new ExcelLineParser();

        System.out.println(lineParser.getLines("test"));
    }
}
