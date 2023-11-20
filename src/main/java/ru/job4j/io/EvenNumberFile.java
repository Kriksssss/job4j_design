package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {

            int read;
            StringBuilder numberStr = new StringBuilder();

            while ((read = in.read()) != -1) {
                char character = (char) read;

                if (Character.isDigit(character)) {
                    numberStr.append(character);
                } else if (numberStr.length() > 0) {
                    processNumber(numberStr.toString());
                    numberStr.setLength(0);
                }
            }

            if (numberStr.length() > 0) {
                processNumber(numberStr.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processNumber(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            boolean isEven = number % 2 == 0;
            System.out.println(number + " is even: " + isEven);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in the file: " + numberStr);
        }
    }
}




