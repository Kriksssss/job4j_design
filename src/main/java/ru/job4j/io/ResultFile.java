package ru.job4j.io;

import java.io.FileOutputStream;

import static java.lang.System.*;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            out.write("1 * 2 = 2".getBytes());
            out.write(lineSeparator().getBytes());
            out.write("1 * 3 = 3".getBytes());
            out.write(lineSeparator().getBytes());
            out.write("1 * 4 = 4".getBytes());
            out.write(lineSeparator().getBytes());
            out.write("1 * 5 = 5".getBytes());
            out.write(lineSeparator().getBytes());
            out.write("1 * 6 = 6".getBytes());
            out.write(lineSeparator().getBytes());
            out.write("1 * 7 = 7".getBytes());
            out.write(lineSeparator().getBytes());
            out.write("1 * 8 = 8".getBytes());
            out.write(lineSeparator().getBytes());
            out.write("1 * 9 = 9".getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

