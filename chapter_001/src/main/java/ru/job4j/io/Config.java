package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * read the file through a buffer.
 * find need elements with the filter and put in a Map.
 *
 * @author Dmitry Faroynts (farodmin@yandex.ru).
 * version 02.
 * @since 09.04.2020.
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {

        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while (read.ready()) {
                String res = read.readLine();
                if (res.contains("=") & !res.startsWith("#")) {
                    String[] splitLine = res.split("=");
                    values.put((splitLine[0]), splitLine[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    /**
     * read the file trough a buffer.
     * create a string.
     *
     * @return
     */

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}


