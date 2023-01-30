package com.tarasov.hometask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.tarasov.hometask.jsonmodel.Employee;
import org.junit.jupiter.api.Test;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParseTest {
    ClassLoader cl = JsonParseTest.class.getClassLoader();

    @Test
    public void parseJsonFile() throws Exception {
        try(InputStream resource = cl.getResourceAsStream("files/jsonexample.json");
            InputStreamReader reader = new InputStreamReader(resource)
        ) {
            ObjectMapper mapper = new ObjectMapper();
            Employee employee = mapper.readValue(reader, Employee.class);

            assertThat(employee.getSalary()).contains("3000 EUR");
            assertThat(employee.isPermanent()).isTrue();
            assertThat(employee.getCities()[1]).contains("Alicante");
            assertThat(employee.getRole()).isEqualTo("Java Automation QA");
            assertThat(employee.getAge()).isEqualTo(36);
        }
    }
}
