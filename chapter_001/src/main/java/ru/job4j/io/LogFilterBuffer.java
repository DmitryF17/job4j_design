package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 * * version 01.
 * * @since 01.04.2020.
 */
public class LogFilterBuffer {
    /**
     * filter for the second from the end.
     *
     * @param file
     * @return null.
     */
    public static List<String> filter(String file) {
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
     * write from a buffer to the file
     *
     * @param res
     */
    public static void save(List<String> res) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("404.txt")
                ))) {
            out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * read the file through a buffer.
     * <p>
     * output filtered elements.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        if (!log.isEmpty()) {
            System.out.println(log);
            save(log);
        }
    }
}