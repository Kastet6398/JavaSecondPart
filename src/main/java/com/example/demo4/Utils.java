package com.example.demo4;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Utils {

    public static String readFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Path.of(fileName)));
        } catch (IOException e) {
            createFile(fileName);
            return "";
        }
    }

    public static void writeFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile(String fileName) {
        try {
            Files.createFile(Path.of(fileName));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
