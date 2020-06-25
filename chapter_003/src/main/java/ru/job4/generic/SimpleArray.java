package ru.job4.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/**
 * Generic for array and create simple arraylist
 *  author DmitryF17
 *  version 01
 *  since 25/06/2019
 */

public class SimpleArray<T> implements Iterable<T> {
    /**
     * creating array universal type
     * creating some metods operating with an array
     * param index for array
     * param iterindex for iterator
     */
    private Object[] object;
    private int index = 0;
    private int iterindex = 0;

    public SimpleArray(int size) {
        this.object = new Object[size];
    }

    public void add(T model) {
        this.object[index++] = model;
    }

    public void set(int indexset, T model) {
        Objects.checkIndex(indexset, index);
        this.object[indexset] = model;
    }

    public void remove(int indexremove) {
        Objects.checkIndex(indexremove, index);
        System.arraycopy(object, indexremove + 1 , object, indexremove, object.length - indexremove - 1);
    }

    public T get(int indexget) {
        Objects.checkIndex(0, index);
        return (T) this.object[indexget];
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterindex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) object[iterindex++];
            }
        };
    }
}
