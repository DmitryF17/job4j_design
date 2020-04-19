package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.StringJoiner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavaibleTest() throws IOException {
        File target = folder.newFile("res.csv");
        File source = folder.newFile("unavailable.csv");
        StringJoiner text = new StringJoiner(System.lineSeparator());
        text.add("200 10:56:01")
                .add("500 10:57:01")
                .add("400 10:58:01")
                .add("200 10:59:01")
                .add("500 11:01:02")
                .add("200 11:02:02");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(source))) {
            out.write(text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader read = new BufferedReader(new FileReader(target))
        ) {
            assertThat(read.readLine(), is("10:57:01 ; 10:59:01"));
            assertThat(read.readLine(), is("11:01:02 ; 11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}