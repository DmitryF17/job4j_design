package ru.job4.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<K> {

    private Node<K, V>[] container;
    private int size = 8;
    private int modCount = 0;
    private int index = 0;
    private Node<K, V> first;
    private Node<K, V> last;

    public SimpleMap() {
        this.container = new Node[size];
    }

    void upsize() {
        this.container = new Node[2 * size];
        for (Node node : container) {
            insert((K) node.key, (V) node.value);
        }
    }

    boolean insert(K key, V value) {
        if (container[hash(key)] != null) {
            return false;
        }
        if (((float) index / size) > 0.75) {
            upsize();
        }
        int ind = hash(key);
        Node<K, V> node = new Node<>(key, value, ind, null);
        Node<K, V> second;
        if (first == null) {
            first = node;
            last = first;
            container[ind] = node;
            modCount++;
            index++;
            return true;
        } else {
            second = last;
            last.next = node;
            last = node;
            last.previous = second;
            container[ind] = node;
            modCount++;
            index++;
            return true;
        }
    }


    V get(K key) {
        V res = null;
        int ind = hash(key);
        if (container[ind].value != null) {
            res = container[ind].value;
        }
        return res;
    }

    boolean delete(K key) {
        boolean res = false;
        Node<K, V> deletenode = container[hash(key)];
        if (container[hash(key)] != null) {
            container[hash(key)] = null;
            res = true;
            if (deletenode.equals(first)) {
                first = null;
            }
            if (deletenode.equals(last)) {
                last = deletenode.previous;
                last.next = null;
            } else {
                deletenode.next.previous = deletenode.previous;
                deletenode.previous.next = deletenode.next;
            }
        }
        return res;
    }


    public int hash(K key) {
        return key.hashCode() % container.length - 1;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int expectedModCount = modCount;
            Node<K, V> iter = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iter != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                var value = iter.key;
                iter = iter.next;
                return value;
            }
        };
    }

    private static class Node<K, V> {
        K key;
        V value;
        int hash;
        Node<K, V> next;
        Node<K, V> previous;

        public Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }
}
