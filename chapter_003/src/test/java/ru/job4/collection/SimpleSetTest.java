package ru.job4.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void whenAddThenIt() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        String rsl = (String) set.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<String> set = new SimpleSet<>();
        set.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        Iterator<String> it = set.iterator();
        set.add("second");
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt2() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        Iterator<String> it = set.iterator();
        set.add("second");
        it.hasNext();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddEDuplicate() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        set.add("first");
        Iterator<String> it = set.iterator();
        it.next();
        it.next();

    }
    @Test(expected = NullPointerException.class)
    public void whenAddNull() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add(null);
        set.add(null);
        Iterator<String> it = set.iterator();
        it.next();
        it.next();
    }
}

