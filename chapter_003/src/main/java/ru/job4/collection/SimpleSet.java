package ru.job4.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleSet<T> extends SimpleArray<T> {

    private int modCount = 0;
    private int index = 0;

    @Override
    public T get(int indexget) {
        Objects.checkIndex(indexget, index);
        return super.get(indexget);
    }

    public boolean checkduplicate(T model) {
        boolean noduplicate = true;
        for (int ind = 0; ind != index; ind++) {
            if (get(ind) == null) {
                throw new NullPointerException();
            }
            if (get(ind).equals(model)) {
                noduplicate = false;
                break;
            }
        }
        return noduplicate;
    }

    @Override
    public void add(T model) {
        if (checkduplicate(model)) {
            super.add(model);
            index++;
            modCount++;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int cursor;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(cursor++);
            }
        };
    }
}
