package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "finish";
    private static final String STOP = "stop";
    private static final String CONTINUE = "continue";
    private final String path;
    private final String botAnswers;
    private final List<String> chatLog = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> phrases = readPhrases();
        if (phrases.isEmpty()) {
            System.out.println("No phrases found. Exiting the program.");
            return;
        }

        boolean chatting = true;
        boolean botActive = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (chatting) {
                String userMessage = scanner.nextLine();
                chatLog.add("User: " + userMessage);

                switch (userMessage.toLowerCase()) {
                    case OUT:
                        chatting = false;
                        break;
                    case STOP:
                        botActive = false;
                        break;
                    case CONTINUE:
                        botActive = true;
                        break;
                    default:
                        String botResponse = generateBotResponse(phrases, botActive);
                        System.out.println("Bot: " + botResponse);
                        chatLog.add("Bot: " + botResponse);
                        break;
                }
            }
        }
        saveLog(chatLog);
        System.out.println("Chat log saved.");
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try {
            Path filePath = Paths.get(path, botAnswers);
            phrases = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try {
            Path logPath = Paths.get(path, "chat_log.txt");
            Files.write(logPath, log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateBotResponse(List<String> phrases, boolean botActive) {
        String response;
        if (botActive) {
            Random random = new Random();
            response = phrases.get(random.nextInt(phrases.size()));
        } else {
            response = "Bot is currently silent.";
        }
        return response;
    }


    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data", "bot_phrases.txt");
        cc.run();
    }
}
