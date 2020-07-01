package ru.job4.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Resizecontainer<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;
    private int size = 0;

    public Resizecontainer() {
        first = null;
        last = null;
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value, size, first);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        modCount++;
        size++;

    }

    public E get(int indexget) {
        Objects.checkIndex(indexget, size);
        Node<E> node = first;
        while (node.index != indexget) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> node = first;
            int expectedModCount = modCount;
            private int cursor;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            @Override

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = node.value;
                node = node.next;
                cursor++;
                return value;
            }
        };
    }

    private static class Node<E> {
        E value;
        int index;
        Node<E> next;

         Node(E value, int index, Node<E> first) {
            this.value = value;
            this.index = index;
            this.next = first;
        }
    }
}

