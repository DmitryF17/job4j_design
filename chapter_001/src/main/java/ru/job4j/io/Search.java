package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.util.List;

public class Search {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "txt").forEach(System.out::println);
    }


    public static List<String> search(Path root, String ext) throws IOException {
        Files.walkFileTree(root, new PrintFiles(ext));
        return new PrintFiles(ext).result();
    }
}
