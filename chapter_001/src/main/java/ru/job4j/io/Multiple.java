package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * Package for IO task.
 *
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 * @version 01.
 * @since 31.03.2020.
 */
public class Multiple {
    private static int[][] table;

    /**
     * Metod multiplication
     *
     * @param size
     * @return
     */
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    /**
     * Metod write result in the file.
     *
     * @param args
     */
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(Arrays.toString(multiple(10)).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}