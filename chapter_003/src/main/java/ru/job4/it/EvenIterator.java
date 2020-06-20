package ru.job4.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;
    private int[] evennum;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
        this.evennum = haseven();
    }

    private int[] haseven() {
        evennum = new int[]{};
        int index = 0;
        for (int even : numbers) {
            if (even % 2 == 0) {
                evennum[index++] = even;
            }
        }
        return evennum;
    }

    @Override
    public boolean hasNext() {
        return point < evennum.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return evennum[point++];
    }
}
