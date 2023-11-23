package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean server = false;
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {

            StringBuilder result = new StringBuilder();

            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (!server && (line.contains("400") || line.contains("500"))) {
                    server = true;
                    result.append(line.split(" ")[1]).append("; ");
                } else if (server && (line.contains("200") || line.contains("300"))) {
                    server = false;
                    result.append(line.split(" ")[1]).append(";\n");
                }
            }

            out.write(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
