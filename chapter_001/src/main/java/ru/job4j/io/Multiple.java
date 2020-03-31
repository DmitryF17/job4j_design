package ru.job4j.io;

import java.io.FileOutputStream;
/**
 * Package for IO task.
 *
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 * @version 01.
 * @since 31.03.2020.
 */
public class Multiple {
    /**
     * Metod multiplication
     *
     * @param size
     * @return
     */
    public static String multiple(int size) {
        int[][] table = new int[size][size];
        StringBuilder expect = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
                expect.append(table[i][j])
                        .append(" ");
            }
            expect.append(System.lineSeparator());
        }
        return expect.toString();
    }

    /**
     * Metod write result in the file.
     *
     * @param args
     */
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(multiple(10).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}