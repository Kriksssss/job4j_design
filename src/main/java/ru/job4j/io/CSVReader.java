package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        if (!Files.exists(Path.of(path))) {
            throw new IllegalArgumentException("File does not exist: " + path);
        }

        String delimiter = argsName.get("delimiter");
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("Invalid delimiter: " + delimiter);
        }
        String out = argsName.get("out");
        String filter = argsName.get("filter");

        List<Integer> filterIndices = new ArrayList<>();
        String[] filterColumns = filter.split(",");
        for (String column : filterColumns) {
            int index = getColumnIndex(path, delimiter, column);
            if (index == -1) {
                throw new IllegalArgumentException("Column not found: " + column);
            }
            filterIndices.add(index);
        }

        try (Scanner scanner = new Scanner(new FileInputStream(path));
             PrintStream output = "stdout".equals(out)
                     ? System.out : new PrintStream(new FileOutputStream(out))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(delimiter);

                StringJoiner resultLine = new StringJoiner(delimiter);
                for (int index : filterIndices) {
                    resultLine.add(columns[index]);
                }

                output.println(resultLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int getColumnIndex(String path, String delimiter, String columnName) throws Exception {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            if (!scanner.hasNextLine()) {
                throw new IllegalArgumentException("File is empty");
            }
            String firstLine = scanner.nextLine();
            String[] columns = firstLine.split(delimiter);
            int index = Arrays.asList(columns).indexOf(columnName);

            if (index == -1) {
                throw new IllegalArgumentException("Column not found: " + columnName);
            }
            return index;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            ArgsName argsName = ArgsName.of(args);
            handle(argsName);
        } else {
            System.out.println("Usage: java CSVReader -path=<path> -delimiter=<delimiter> -out=<stdout or file> -filter=<columns>");
        }
    }
}