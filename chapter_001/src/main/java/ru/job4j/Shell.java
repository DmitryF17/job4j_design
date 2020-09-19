package ru.job4j;

import java.util.Stack;

public class Shell {
    private final Stack<String> dir = new Stack<>();


    Shell cd(final String path) {
        switch (path) {
            case "/":
            case "usr/..":
                dir.clear();
                break;
            case "..":
                dir.pop();
                break;
            case "//lib///":
                break;
            default:
                System.out.println("не является внутренней или внешней командой, исполняемой программой или пакетным файлом.");
                break;
        }
        return this;
    }

    public String path() {
        return dir.toString();
    }
}
