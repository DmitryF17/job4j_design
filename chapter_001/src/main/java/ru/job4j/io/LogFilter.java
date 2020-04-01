package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * read the file through a buffer.
 * find need elements with the filter out off String.
 *
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 * version 01.
 * @since 01.04.2020.
 */

public class LogFilter {
    public List<String> lines;

    /**
     * filter for the second from the end.
     *
     * @param file
     * @return null.
     */

    public static List<String> filter(String file) {
        String[] lin = file.split(" ");
        if (lin[lin.length - 2].equals("404")) {
            return Collections.singletonList(file);
        }
        return null;
    }

    /**
     * read the file through a buffer.
     * output filtered elements to a console.
     *
     * @param args
     */

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                List<String> log = filter(line);
                if (log != null) {
                    System.out.println(log);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



