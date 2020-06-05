package ru.job4j.searchfile;

/**
 * create search parameters.
 *
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 * version 01.
 * @since 03.06.2020.
 */

public class ArgsSearch {

    private static String[] args;

    public ArgsSearch(String[] args) {
        this.args = args;
    }

    boolean valid() {
        if (args.length < 7) {
            System.out.println("args is invalid");
        }
        return true;
    }

    String directory() {
        return args[1];
    }

    String searchname() {
        return args[3];
    }

    String searchlevel() {
        return args[4];
    }

    public String output() {
        return args[6];
    }
}
