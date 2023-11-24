package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), visitor);

        Map<FileProperty, List<Path>> duplicates = visitor.getDuplicates();
        printDuplicates(duplicates);
    }

    private static void printDuplicates(Map<FileProperty, List<Path>> duplicates) {
        for (Map.Entry<FileProperty, List<Path>> entry : duplicates.entrySet()) {
            System.out.println("Duplicate files for " + entry.getKey() + ":");
            for (Path path : entry.getValue()) {
                System.out.println(path);
            }
            System.out.println();
        }
    }
}
