package ru.job4.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;
    private int point = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int allelement = 0;
        for (int[] dat : data) {
            allelement += dat.length;
        }
        return point < allelement;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        while (data[row].length == 0) {
            row++;
        }
        point++;
        return data[row][column++];
    }
}
