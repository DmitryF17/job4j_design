package ru.job4j.console;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

class TextLog {

    static void search(List<String> chat) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("textlog.txt")
                ))) {
            out.println(chat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
