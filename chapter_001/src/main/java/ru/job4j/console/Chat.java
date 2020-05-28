package ru.job4j.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chat {
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String END = "закончить";
    private static List<String> chat = new ArrayList<>();

    private static void chat() throws IOException {
        var ans = new ChatAnswer().answer();
        boolean order = true;
        boolean search = true;
        System.out.print("Поговорим?");
        do {
            String question = new ConsoleInput().ask();
            chat.add(question);
            switch (question) {
                case STOP:
                    search = false;
                    order = true;
                    break;
                case CONTINUE:
                    search = true;
                    order = true;
                    break;
                case END:
                    search = false;
                    order = false;
                    break;
                default:
            }
            if (search) {
                Collections.shuffle(ans);
                var answer = ans.get(0);
                chat.add(answer);
                System.out.println(answer);
            }
            chat.add(System.lineSeparator());
        } while (order);
        TextLog.search(chat);
    }

    public static void main(String[] args) throws IOException {
        Chat.chat();
    }
}

