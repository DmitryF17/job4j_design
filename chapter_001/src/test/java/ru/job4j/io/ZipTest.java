package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.StringJoiner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ZipTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void zipTest() throws IOException {
        File target = folder.newFile("pom.zip");
        File source = folder.newFile("pom.xml");
        StringJoiner text = new StringJoiner(System.lineSeparator());
        text.add("analizy.txt")
                .add("notanalizy.jpeg")
                .add("notanalizy.raw");
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(source)))) {
            zip.putNextEntry(new ZipEntry(source.getAbsolutePath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

            var args = new String[]{"pom.xml", "txt", "pom.zip"};
            new Zip().packFiles(new Zip().searcher(args), new File(new Argzip(args).output()));

            try (ZipInputStream outp = new ZipInputStream((new FileInputStream(target)))) {
                ZipEntry entry;
                while ((entry = outp.getNextEntry()) != null) {
                    var res = entry.getName();
                    outp.closeEntry();
                    assertThat(res, is("analizy.txt"));
                }
            }
        }
    }
}
