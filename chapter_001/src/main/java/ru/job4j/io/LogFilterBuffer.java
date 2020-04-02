package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 *  * version 01.
 *  * @since 01.04.2020.
 */
public class LogFilterBuffer {
    /**
     * filter for the second from the end.
     *
     * @param file
     * @return file.
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
     *write from a buffer to the file
     * @param res
     */
    public static void save(List<String> res) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("404.txt")
                ))) {
            out.write(String.valueOf(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *read the file through a buffer.
     *
     *output filtered elements.
     * @param args
     */
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            List<String> lines = new ArrayList<>();
            List<String> res = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                List<String> log = filter(line);
                if (log != null) {
                   res.add(line);
                }
            }
            save(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}