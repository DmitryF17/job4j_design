package ru.job4j.kiss;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {
    static List<Integer> value = List.of(10, 20, 50, 15, 35, 75, 5);

    @Test
    public void maxTest() {
        assertThat(new MaxMin().max(value), is(75));
    }

    @Test
    public void minTest() {
        assertThat(new MaxMin().min(value), is(5));
    }
}
