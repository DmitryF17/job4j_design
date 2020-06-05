package ru.job4j.searchfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Searcher {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        WriteFile.write(search(args), new ArgsSearch(args).output());
    }

    public static List<Path> search(String[] args) throws IOException {
        ArgsSearch argsSearch = new ArgsSearch(args);
        SearchFile searcher = new SearchFile(new ParameterSearch().parameter(argsSearch.searchlevel(), argsSearch.searchname()));
        Files.walkFileTree(Paths.get(argsSearch.directory()), searcher);
        return searcher.getPath();
    }
}
