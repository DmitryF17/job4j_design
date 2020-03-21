package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    static List<Integer> value = List.of(10, 20, 50, 15, 35, 75, 5);

     Integer findMaxMin(List<Integer> value, Comparator<Integer> comparator) {
        Integer rsl = value.get(0);
        for (Integer val : value) {
            if (comparator.compare(val, rsl) > 0) {
                rsl = val;
            }
        }
        return rsl;
    }

    public Integer max(List<Integer> value) {
        return findMaxMin(value, val -> val.min(a, b));
    }

    public Integer min(List<Integer> value) {
        return findMaxMin(value, Integer::min);
    }

    public static void main(String[] args) {
        MaxMin result = new MaxMin();
        System.out.println(result.max(value));
        System.out.println(result.min(value));
    }
}