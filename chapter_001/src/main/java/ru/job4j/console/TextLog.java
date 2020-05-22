package ru.job4j.console;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TextLog {
    static private List<String> res = new ArrayList<>();
    static  void search(String chat) {
            res.add(chat);
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("textlog.txt")
                ))) {
            out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
