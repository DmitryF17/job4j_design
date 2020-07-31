package ru.job4.task;

import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] firstword = left.toCharArray();
        char[] nextword = right.toCharArray();
        Arrays.sort(firstword);
        Arrays.sort(nextword);
        int res = Arrays.compare(firstword, nextword);
        return res == 0;
    }
}