package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

     void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<File> searcher(String[] args) throws IOException {
        List<File> out = new ArrayList<>();
        Argzip argsZip = new Argzip(args);
        if (argsZip.valid()) {
            List<Path> direct = Search.search(Paths.get(argsZip.directory()), argsZip.exclude());
            out = direct.stream().map(Path::toFile).collect(Collectors.toList());
        }
        return out;
    }
    public static void main(String[] args) throws IOException {
            new Zip().packFiles(searcher(args), new File(new Argzip(args).output()));
        }

}
