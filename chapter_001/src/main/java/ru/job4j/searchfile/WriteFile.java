package ru.job4j.searchfile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class WriteFile {
    public static void write(List<Path> search, String target) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            out.println(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}