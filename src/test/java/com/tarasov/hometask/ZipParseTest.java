package com.tarasov.hometask;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipParseTest {
    ClassLoader cl = ZipParseTest.class.getClassLoader();

    @Test
    public void parseZipArchive() throws Exception {
        try(InputStream resource = cl.getResourceAsStream("files/taskfiles.zip");
            ZipInputStream zis = new ZipInputStream(resource);
        ) {
            ZipEntry zipEntry;

            while ((zipEntry = zis.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());

                if (zipEntry.getName().endsWith(".xlsx")) {
                    XLS xlsParser = new XLS(zis);

                    String value = xlsParser.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue();
                    assertThat(value).contains("Madrid");
                }
                if (zipEntry.getName().equals(".pdf")) {
                    PDF pdfParser = new PDF(zis);

                    assertThat(pdfParser.author).contains("Ramesh Fadatare");
                    assertThat(pdfParser.numberOfPages).isEqualTo(6);
                    assertThat(pdfParser.text).contains("Comment Resource REST");
                }
                if (zipEntry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = csvReader.readAll();

                    assertThat(content.get(3)[1]).contains("Rome");
                    assertThat(content.size()).isEqualTo(4);
                }
            }
        }
    }
}
