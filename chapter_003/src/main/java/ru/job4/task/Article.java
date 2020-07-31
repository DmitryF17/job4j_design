package ru.job4.task;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean res = true;
        String[] newtext = line.split(" ");
        for (String word : newtext) {
            if (!origin.contains(word)) {
                res = false;
                break;
            }
        }
        return res;
    }
}
