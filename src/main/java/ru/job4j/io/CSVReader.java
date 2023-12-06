package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");

        if (path == null || delimiter == null || out == null || filter == null) {
            throw new IllegalArgumentException("All parameters are required");
        }

        List<Integer> filterIndices = new ArrayList<>();
        String[] filterColumns = filter.split(",");
        for (String column : filterColumns) {
            filterIndices.add(getColumnIndex(path, delimiter, column));
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
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                String[] columns = firstLine.split(delimiter);

                int columnIndex = Arrays.asList(columns).indexOf(columnName);
                if (columnIndex != -1) {
                    return columnIndex;
                } else {
                    throw new IllegalArgumentException("Column not found: " + columnName);
                }
            } else {
                throw new IllegalArgumentException("File is empty");
            }
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                ArgsName argsName = ArgsName.of(args);
                handle(argsName);
            } else {
                System.out.println("Usage: java CSVReader -path=<path> -delimiter=<delimiter> -out=<stdout or file> -filter=<columns>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}