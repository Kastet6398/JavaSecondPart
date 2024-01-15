package com.example.demo4.utils;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Utils extends BaseUtilityClass {
    private static final Gson gson = new Gson();
    private Utils() {
        super();
    }


    //////////////////////
    ///    VARIABLES   ///
    //////////////////////
    public static String addSpaceBeforeCapital(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (i > 0 && Character.isUpperCase(currentChar))
                result.append(" ");
            result.append(currentChar);
        }
        return result.toString();
    }
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static Object fromJson(String json, Class<?> clazz) {
        return gson.fromJson(json, clazz);
    }

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

    public static void save(Object drawingsConfig, String filenameString) {
        Utils.writeFile(filenameString, Utils.toJson(drawingsConfig));
    }
}
