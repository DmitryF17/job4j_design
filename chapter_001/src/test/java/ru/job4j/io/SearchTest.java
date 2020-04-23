package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class SearchTest {
    @Test
    public void searchTest() throws IOException {
        List<String> res = new Search().search(Paths.get("."), "txt");
        boolean ext = true;
        for (String rs : res) {
            if (!rs.endsWith("txt")) {
                ext = false;
            }
        }
        assertThat(ext, is(true));
    }
}
