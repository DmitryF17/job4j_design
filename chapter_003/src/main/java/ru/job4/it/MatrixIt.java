package ru.job4.it;
/**
 * Package for iterators.
 * author DmitryF17
 * version 01
 * since 17/06/2019
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *  An iterator for a two-dimensional array
 *  author DmitryF17
 *  version 02
 *  since 19/06/2019
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * method where elements are checked in each nested array
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        while ((column >= data[row].length || data[row].length == 0) & row != data.length - 1) {
            row++;
            column = 0;
        }
        return data[row].length > column;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
