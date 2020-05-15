package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;

import java.util.List;


public class Search {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(args[0]);
        List<Path> res = search(start, args[1]);
        res.stream().map(Path::toString).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        PrintFiles searcher = new PrintFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}


