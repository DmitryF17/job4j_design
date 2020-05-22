package ru.job4j.console;

import java.util.Scanner;

public class ConsoleInput {

    String ask() throws IllegalArgumentException {
            Scanner input = new Scanner(System.in);
            var value = input.nextLine();
        if (value.isEmpty() || value.equals(" ")) {
            throw new RuntimeException("Please write your word");
        }
        return value;
    }
}
