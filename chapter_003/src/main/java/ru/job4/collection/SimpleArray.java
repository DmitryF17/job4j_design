package ru.job4.collection;

import java.util.*;

/**
 * resizable-array implementation
 * author DmitryF17
 * version 01
 * since 29/06/2019
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * creating array universal type
     * creating some metods operating with an array
     * param modCount for counting changes in an array
     * param index for array
     * param iterindex for iterator
     */
    private Object[] container = {};
    private int modCount = 0;
    private int size = 10;
    private int index = 0;


    public SimpleArray() {
        this.container = new Object[size];
    }

    public T get(int indexget) {
        Objects.checkIndex(indexget, index);
        return (T) container[indexget];
    }

    public void add(T model) {
        if (index >= size) {
            container = Arrays.copyOf(container, 2 * size);
        }
        modCount++;
        container[index++] = model;
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
                return (T) container[cursor++];
            }
        };
    }
}
