package ru.job4.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

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
    private int iterindex = 0;

    public SimpleArray() {
        this.container = new Object[size];
    }

    public T get(int indexget) {
        Objects.checkIndex(indexget, index);
        return (T) container[indexget];
    }

    public void add(T model) {
        if (index >= size) {
            size = size + 10;
            this.container = new Object[size];
        }
        modCount++;
        container[index++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterindex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[iterindex++];
            }
        };
    }
}
