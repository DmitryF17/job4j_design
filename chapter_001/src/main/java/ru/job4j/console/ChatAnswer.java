package ru.job4j.console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatAnswer {

    String answer() {
        List<String> res = new ArrayList<>();
        try (
                BufferedReader in = new BufferedReader(new FileReader("answer.txt"))) {
            while (in.ready()) {
                String line = in.readLine();
                    res.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.shuffle(res);
        return res.get(0);
    }
}
