package ru.job4j.io;

public class Argzip {
    private String[] args;

    Argzip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 3) {
            System.out.println("args is not valid");
        }
        return true;
    }

    public String directory() {
        return args[0];
    }

    public String exclude() {
        return args[1];
    }

    public String output() {
        return args[2];
    }
}
