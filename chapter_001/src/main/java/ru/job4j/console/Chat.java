package ru.job4j.console;

public class Chat {

    static void chat() {
        System.out.print("Поговорим?");
        boolean order = true;
        boolean search = true;
        do {
            String name = new ConsoleInput().ask();
            TextLog.search(name);
            switch (name) {
                case "стоп":
                    search = false;
                    order = true;
                    break;
                case "продолжить":
                    search = true;
                    order = true;
                    break;
                case "закончить":
                    search = false;
                    order = false;
                    break;
                default:
            }
            if (search) {
                var ans = new ChatAnswer().answer();
                System.out.println(ans);
                TextLog.search(ans);
            }

        } while (order);
    }

    public static void main(String[] args) {
        Chat.chat();
    }
}

