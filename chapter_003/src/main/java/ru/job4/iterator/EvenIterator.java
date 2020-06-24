package ru.job4.iterator;
/**
 * Package for iterators.
 * author DmitryF17
 * version 01
 * since 17/06/2019
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *  An iterator for a even numbers
 *  author DmitryF17
 *  version 03
 *  since 20/06/2019
 */

public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }
    /**
     * a method where even number create index for array and check end of array
     * @return boolean
     */
    @Override
    public boolean hasNext() {

        while (numbers[point] % 2 != 0 & point < numbers.length - 1) {
            point++;
        }
        return numbers[point] % 2 == 0;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[point++];
    }
}
