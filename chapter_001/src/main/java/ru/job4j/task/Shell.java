package ru.job4j.task;

public class Shell {
    private String directory = "/";

    Shell cd(final String path) {
        switch (path) {
            case "/":
            case "usr/..":
                this.directory = "/";
                break;
            case "usr":
            case "local":
            case "../local":
            case "./":
                this.directory = "/usr/local";
                break;
            case "..":
                this.directory = "/usr";
            case "//lib///":
                this.directory = "/lib";
            default:
        }
        return this;
    }

    public String path() {
        return directory;
    }
}
