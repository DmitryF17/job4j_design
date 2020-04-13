package ru.job4j.io;

import java.io.*;

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
    public static void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)));
            boolean check = false;
            while (in.ready()) {
                String line = in.readLine();
                String[] lin = line.split(" ");
                String[] lin1 = line.split(" ");
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
        try (PrintWriter out = new PrintWriter(new FileOutputStream("chapter_001/unavailable.csv"))) {
            out.write("200 10:56:01" + System.lineSeparator()
                    + "500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable("chapter_001/unavailable.csv", "chapter_001/res.csv");
    }
}



