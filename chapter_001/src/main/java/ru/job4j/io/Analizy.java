package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            boolean check = false;
            for (int ind = 0; ind < lines.size() - 1; ind++) {
                String[] lin = lines.get(ind).split(" ");
                String[] lin1 = lines.get(ind + 1).split(" ");

                if (!check & (lin[0].equals("400") || lin[0].equals("500"))) {
                    out.print((lin[1]) + " ; ");
                    check = true;
                }
                if (check & (lin1[0].equals("200") || lin1[0].equals("300"))) {
                    out.println(lin1[1]);
                    check = false;
                }

            }

            out.close();
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
        try (PrintWriter out = new PrintWriter(new FileOutputStream("./data/unavailable.csv"))) {
            out.write("200 10:56:01/n"
                    + "500 10:57:01/n"
                    + "400 10:58:01/n"
                    + "200 10:59:01/n"
                    + "500 11:01:02/n"
                    + "200 11:02:02/n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable("./data/unavailable.csv", "./data/res.csv");
    }
}



