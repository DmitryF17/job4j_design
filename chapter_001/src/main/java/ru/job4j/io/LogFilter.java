package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
    /**
     * filter for the second from the end.
     *
     * @param file
     * @return null.
     */
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while (in.ready()) {
                String line = in.readLine();
                String[] lin = line.split(" ");
                if (lin[lin.length - 2].equals("404")) {
                    res.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * read the file through a buffer.
     * output filtered elements to a console.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}








