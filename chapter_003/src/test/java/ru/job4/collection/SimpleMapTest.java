package ru.job4.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {
    @Test
    public void addMap() {
        SimpleMap<Integer, Integer> simplemap = new SimpleMap<>();
        simplemap.insert(1, 2);
        simplemap.insert(2, 2);
        assertThat(simplemap.get(1), is(2));
    }

    @Test(expected = NullPointerException.class)
    public void deleteMap() {
        SimpleMap<Integer, Integer> simplemap = new SimpleMap<>();
        simplemap.insert(1, 2);
        simplemap.delete(1);
        simplemap.get(1);
    }

    @Test
    public void deleteNoMap() {
        SimpleMap<Integer, Integer> simplemap = new SimpleMap<>();
        simplemap.insert(1, 2);
        assertThat(simplemap.delete(2), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void whenGetEmpty() {
        SimpleMap<String, String> simplemap = new SimpleMap<>();
        simplemap.get("1");
    }
    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        SimpleMap<String, Integer> simplemap = new SimpleMap<>();
        simplemap.insert("1", 1);
        simplemap.insert("5", 2);
        simplemap.insert("3", 3);
        Iterator<String> it = simplemap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("5"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
    @Test
    public void addWhenMapThereIs() {
        SimpleMap<Integer, Integer> simplemap = new SimpleMap<>();
        simplemap.insert(1, 2);
        assertThat(simplemap.insert(1, 3), is(false));
    }
    @Test
    public void addWhenMapThereIsNo() {
        SimpleMap<Integer, Integer> simplemap = new SimpleMap<>();
        simplemap.insert(1, 2);
        assertThat(simplemap.insert(2, 3), is(true));
    }
}
