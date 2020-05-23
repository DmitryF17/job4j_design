package ru.job4j.console;

import java.io.IOException;
import java.util.Scanner;

class ConsoleInput {

    String ask() throws IOException {
        Scanner input = new Scanner(System.in);
        var value = input.nextLine();
        if (value.isEmpty() || value.equals(" ")) {
            throw new IOException("Please write your word");
        }
        return value;
    }
}
