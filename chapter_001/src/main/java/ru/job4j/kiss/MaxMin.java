package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

   public Integer findMaxMin(List<Integer> value, Comparator<Integer> comparator) {
        Integer rsl = value.get(0);
        for (Integer val : value) {
            if (comparator.compare(val, rsl) > 0) {
                rsl = val;
            }
        }
        return rsl;
    }

    public Integer min(List<Integer> value) {
        return findMaxMin(value, (first, second) -> second.compareTo(first));
    }

    public Integer max(List<Integer> value) {
        return findMaxMin(value, (first, second) -> first.compareTo(second));
    }
}