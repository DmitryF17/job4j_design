package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * file conversion.
 *
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 * version 01.
 * @since 31.03.2020.
 */
public class Analizy {
    /**
     * read the file with a buffer.
     * validate a diapason.
     * write to the file.
     *
     * @param source
     * @param target
     */
    public void unavailable(String source, String target) {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean check = false;
            while (in.ready()) {
                String line = in.readLine();
                if (!check & (line.startsWith("400") || line.startsWith("500"))) {
                    res.add((line.substring(4) + " ; "));
                    check = true;
                }
                if (check & (line.startsWith("200") || line.startsWith("300"))) {
                    res.add(line.substring(4) + System.lineSeparator());
                    check = false;
                }
            }
            res.forEach(out::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * create source file.
     *
     * @param args
     */
    public static void main(String[] args) {
        StringJoiner text = new StringJoiner(System.lineSeparator());
        text.add("200 10:56:01")
                .add("500 10:57:01")
                .add("400 10:58:01")
                .add("200 10:59:01")
                .add("500 11:01:02")
                .add("200 11:02:02");
        try (PrintWriter out = new PrintWriter(new FileOutputStream("chapter_001/unavailable.csv"))) {
            out.write(text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable("chapter_001/unavailable.csv", "chapter_001/res.csv");
    }
}





