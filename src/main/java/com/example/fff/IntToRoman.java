package com.example.fff;

import java.util.Collections;
import java.util.TreeMap;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(99));
    }
    private static final TreeMap<Integer, String> romanNumerals = new TreeMap<>(Collections.reverseOrder());

    static {
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    public static String intToRoman(int num) {
        if (num <= 0)
            return null;

        StringBuilder result = new StringBuilder();
        for (int value : romanNumerals.keySet()) {
            while (num >= value) {
                result.append(romanNumerals.get(value));
                num -= value;
            }
        }
        return result.toString();
    }
}
