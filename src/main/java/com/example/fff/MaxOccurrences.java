package com.example.fff;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccurrences {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 9, 4, 3, 5, 6, 5, 2, 7, 8, 7, 9, 9, 9};

        int res = mostPopularNumber(numbers);
        System.out.println(STR."The most \"popular\" number is: \{res}");
    }

    public static int mostPopularNumber(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }

        Map<Integer, Long> occurrences = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<Integer, Long> maxEntry = occurrences.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        return maxEntry.getKey();
    }
}
